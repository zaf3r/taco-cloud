package com.zaf3r.tacocloud.controller;

import com.zaf3r.tacocloud.model.Ingredient;
import com.zaf3r.tacocloud.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping(path="/ingredientsx", produces="application/json")
@CrossOrigin(origins="*")
public class IngredientController {

    private IngredientRepository repo;
    private RestTemplate restTemplate;

    @Autowired
    public IngredientController(IngredientRepository repo) {
        this.repo = repo;
        this.restTemplate = getRestTemplate();
    }

    @GetMapping
    public Iterable<Ingredient> allIngredients() {
        return repo.findAll();
    }
    public Ingredient getIngredientById(String ingredientId) {
        Map<String, String> urlVariables = new HashMap<>();
        urlVariables.put("id",ingredientId);
        return restTemplate.getForObject(" http://localhost:8080/ingredients/{id}",
                Ingredient.class,urlVariables);
    }

    @Bean
    private RestTemplate getRestTemplate(){
        return new RestTemplate();
    }
}
