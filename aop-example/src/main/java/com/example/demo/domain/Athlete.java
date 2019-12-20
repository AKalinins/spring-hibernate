package com.example.demo.domain;

import org.springframework.stereotype.Component;

@Component
public class Athlete {

    public String run(boolean shoesUntied) throws InterruptedException {
        System.out.println("Athlete starts running");
        if (shoesUntied) throw new RuntimeException("Athlete trips because his shoelaces are untied.");
        Thread.sleep(5000);
        System.out.println("Athlete stops running");
        return "Success";
    }
}
