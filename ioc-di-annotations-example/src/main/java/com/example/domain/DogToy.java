package com.example.domain;

import org.springframework.stereotype.Component;

@Component
public class DogToy implements Toy {

    @Override
    public String play() {
        return "Dog runs after a ball.";
    }
}
