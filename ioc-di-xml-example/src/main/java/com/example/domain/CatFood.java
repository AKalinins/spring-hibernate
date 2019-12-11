package com.example.domain;

public class CatFood implements Food {

    @Override
    public String eat() {
        return "Cat eats cat food.";
    }
}
