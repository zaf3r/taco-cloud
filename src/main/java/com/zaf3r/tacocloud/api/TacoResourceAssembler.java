package com.zaf3r.tacocloud.api;

import com.zaf3r.tacocloud.controller.DesignTacoController;
import com.zaf3r.tacocloud.model.Taco;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;

public class TacoResourceAssembler extends RepresentationModelAssemblerSupport<Taco, TacoResource> {

    public TacoResourceAssembler() {
        super(DesignTacoController.class, TacoResource.class);
    }

    @Override
    public TacoResource toModel(Taco entity) {
        return new TacoResource(entity);
    }

    @Override
    public CollectionModel<TacoResource> toCollectionModel(Iterable<? extends Taco> entities) {
        return  super.toCollectionModel(entities);
    }
}
