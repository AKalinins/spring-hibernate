package com.example.domain;

public class Cat implements Animal {

    private String name;

    private Toy toy;
    private Food food;

    public Cat(Toy toy) {
        this.toy = toy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFood(Food food) {
        this.food = food;
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

    //Hooks
    private void init() {
        System.out.println(getName() + " wakes up.");
    }

    private void destroy() {
        System.out.println(getName() + " goes to sleep.");
    }
}
