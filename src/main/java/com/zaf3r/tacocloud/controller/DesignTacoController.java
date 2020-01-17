package com.zaf3r.tacocloud.controller;

import com.zaf3r.tacocloud.model.Design;
import com.zaf3r.tacocloud.model.Ingredient;
import com.zaf3r.tacocloud.model.Taco;
import com.zaf3r.tacocloud.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.zaf3r.tacocloud.model.Ingredient.Type;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/design", produces = "application/json")
@CrossOrigin(origins = "*")
public class DesignTacoController {

    @Autowired
    private TacoRepository tacoRepo;

    public DesignTacoController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping
    public Collection<Taco> recentTacos(){
        PageRequest page = PageRequest.of(0,12, Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }

}
