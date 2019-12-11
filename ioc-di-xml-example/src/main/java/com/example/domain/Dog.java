package com.example.domain;

public class Dog implements Animal {

    private String name;
    private String color;
    private Toy toy;
    private Food food;
    private Cat cat;

    public void setToy(Toy toy) {
        this.toy = toy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
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

    public void runAfterCat() {
        System.out.println(getName() + " runs after " + cat.getName() + ".");
    }
}
