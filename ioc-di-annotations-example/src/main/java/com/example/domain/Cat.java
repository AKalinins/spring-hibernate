package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Cat implements Animal {

    @Value("${cat.name}") //value setter
    private String name;

    private Toy toy;

    @Autowired //Field injection
    @Qualifier("catFood") //Pick exact implementation of Food
    private Food food;

    @Autowired //Constructor injection
    public Cat(@Qualifier("catToy") Toy toy) {
        this.toy = toy;
    }

    public String getName() {
        return name;
    }

    @Override
    public String makeSound() {
        return "Meow.";
    }

    @Override
    public String play() {
        return toy.play();
    }

    public String eat() {
        return food.eat();
    }

    //Hooks examples
    @PostConstruct
    private void init() {
        System.out.println(getName() + " wakes up");
    }

    @PreDestroy
    private void destroy() {
        System.out.println(getName() + " goes to sleep");
    }
}
