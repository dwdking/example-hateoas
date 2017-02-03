package com.example.hateoas.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hateoas.model.ExampleResource;

@RestController
@ExposesResourceFor(ExampleResource.class)
@RequestMapping(value = "workingExample", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class WorkingExampleController {

    @GetMapping
    public ExampleResource getResource() {
        ExampleResource resource = new ExampleResource();
        resource.setInternalId(1);
        try {
            resource.add(linkTo(WorkingExampleController.class, WorkingExampleController.class.getMethod("getResource"), new Object[0])
                    .withSelfRel());
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }

        return resource;
    }

}
