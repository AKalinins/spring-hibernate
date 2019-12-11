package com.example;

import com.example.domain.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyAnnotationsDemoApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("META-INF/spring/applicationContext.xml");

        Animal cat = context.getBean("cat", Animal.class);

        System.out.println(cat.makeSound());

        //Method call using constructor injected dependency
        System.out.println(cat.play());

        //Method call using field injection
        System.out.println(cat.eat());

        Animal dog = context.getBean("dog", Animal.class);

        System.out.println(dog.makeSound());

        //Method call using setter injected dependency and method injected dependency
        System.out.println(dog.play());
        System.out.println(dog.eat());

        //Scope test
        Food dogFood1 = context.getBean("dogFood", Food.class);
        Food dogFood2 = context.getBean("dogFood", Food.class);

        System.out.println("All food are the same object = " + (dogFood1 == dogFood2));

        Animal dog2 = context.getBean("dog", Animal.class);

        System.out.println("All dogs are the same object = " + (dog == dog2));

        context.close();
    }
}
