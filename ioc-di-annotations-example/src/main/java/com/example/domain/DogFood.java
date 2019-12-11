package com.example.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class DogFood implements Food {

    @Override
    public String eat() {
        return "Dog eats dog food.";
    }
}
