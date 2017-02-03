package com.example.hateoas.model;

import org.springframework.hateoas.ResourceSupport;

public class ExampleResource extends ResourceSupport {

    private int internalId;

    public int getInternalId() {
        return internalId;
    }

    public void setInternalId(int internalId) {
        this.internalId = internalId;
    }
}
