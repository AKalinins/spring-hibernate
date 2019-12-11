package org.example.domain;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class CatFood implements Food {

    @Override
    public String eat() {
        return "Cat eats cat food.";
    }
}
