package com.example.domain;

public class DogFood implements Food {

    @Override
    public String eat() {
        return "Dog eats dog food.";
    }
}
