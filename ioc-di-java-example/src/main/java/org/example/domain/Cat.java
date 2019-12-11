package org.example.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class Cat implements Animal {

    @Value("${cat.name}") //value setter
    private String name;

    private Toy toy;
    private Food food;

    public Cat(Toy toy, Food food) {
        this.toy = toy;
        this.food = food;
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
