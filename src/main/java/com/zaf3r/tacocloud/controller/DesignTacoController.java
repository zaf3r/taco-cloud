package com.zaf3r.tacocloud.controller;

import com.zaf3r.tacocloud.api.TacoResource;
import com.zaf3r.tacocloud.api.TacoResourceAssembler;
import com.zaf3r.tacocloud.model.Taco;
import com.zaf3r.tacocloud.repository.TacoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


import java.util.List;
import java.util.Optional;

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

    @GetMapping("/recent")
    public CollectionModel<TacoResource> recentTacos() {
        PageRequest page = PageRequest.of(
                0, 12, Sort.by("createdAt").descending());
        List<Taco> tacos = tacoRepo.findAll(page).getContent();
        CollectionModel<TacoResource> tacoResources = new TacoResourceAssembler().toCollectionModel(tacos);
        tacoResources.add(
            linkTo(methodOn(DesignTacoController.class).recentTacos())
                    .withRel("recents"));
        return tacoResources;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Taco> tacoById(@PathVariable("id") long id){
        Optional<Taco> optTaco = tacoRepo.findById(id);
        if(optTaco.isPresent()){
            return new ResponseEntity<>(optTaco.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Taco postTaco(@RequestBody Taco taco) {
        return tacoRepo.save(taco);
    }
}
