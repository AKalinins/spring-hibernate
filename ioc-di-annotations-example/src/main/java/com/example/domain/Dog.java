package com.example.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal {

    @Value("${dog.name}") //value setter
    private String name;

    private Toy toy;

    @Autowired //Field injection
    @Qualifier("dogFood") //Pick exact implementation of Food
    private Food food;

    Cat cat;

    @Autowired //setter injection
    @Qualifier("dogToy") //pick exact implementation of Toy
    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public String getName() {
        return name;
    }

    @Override
    public String makeSound() {
        return "Wof.";
    }

    @Override
    public String play() {
        return toy.play();
    }

    @Override
    public String eat() {
        return food.eat();
    }

    @Autowired //method injection
    public void runAfterCat(Cat cat) {
        this.cat = cat;
        System.out.println(getName() + " runs after " + cat.getName());
    }
}
