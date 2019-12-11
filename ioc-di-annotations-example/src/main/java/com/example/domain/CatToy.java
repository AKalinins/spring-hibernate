package com.example.domain;

import org.springframework.stereotype.Component;

@Component
public class CatToy implements Toy {

    @Override
    public String play() {
        return "Cat preys on a rubber mouse.";
    }
}
