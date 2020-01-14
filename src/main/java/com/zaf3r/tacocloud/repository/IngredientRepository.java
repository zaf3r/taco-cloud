package com.zaf3r.tacocloud.repository;

import com.zaf3r.tacocloud.model.Ingredient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
