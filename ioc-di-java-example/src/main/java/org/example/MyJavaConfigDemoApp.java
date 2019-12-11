package org.example;

import org.example.config.SpringConfig;
import org.example.domain.Animal;
import org.example.domain.Food;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MyJavaConfigDemoApp {

    public static void main(String[] args) {

       AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        Animal cat = context.getBean("cat", Animal.class);

        System.out.println(cat.makeSound());

        //Method call using constructor injected dependency
        System.out.println(cat.play());

        //Method call using field injection
        System.out.println(cat.eat());

        //Scope test
        Food catFood1 = context.getBean("catFood", Food.class);
        Food catFood2 = context.getBean("catFood", Food.class);

        System.out.println("All food are the same object = " + (catFood1 == catFood2));

        Animal cat2 = context.getBean("cat", Animal.class);

        System.out.println("All cats are the same object = " + (cat == cat2));

        context.close();
    }
}
