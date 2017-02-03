package com.example.hateoas.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import org.springframework.hateoas.ExposesResourceFor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.hateoas.JsonUtf8RequestMapping;
import com.example.hateoas.model.ExampleResource;

@RestController
@ExposesResourceFor(ExampleResource.class)
@JsonUtf8RequestMapping(value = "notWorkingExample")
public class NotWorkingExampleController {

    @GetMapping
    public ExampleResource getResource() {
        ExampleResource resource = new ExampleResource();
        resource.setInternalId(1);
        try {
            resource.add(
                    linkTo(NotWorkingExampleController.class, NotWorkingExampleController.class.getMethod("getResource"), new Object[0])
                            .withSelfRel());
        } catch (NoSuchMethodException ex) {
            throw new RuntimeException(ex);
        }

        return resource;
    }

}
