package com.zaf3r.tacocloud.api;

import com.zaf3r.tacocloud.model.Ingredient;
import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.hateoas.server.core.Relation;

@Relation(value="ingredient", collectionRelation="ingredients")
public class IngredientResource extends RepresentationModel<IngredientResource> {
    @Getter
    private String name;
    @Getter
    private Ingredient.Type type;
    public IngredientResource(Ingredient ingredient) {
        this.name = ingredient.getName();
        this.type = ingredient.getType();
    }
}
