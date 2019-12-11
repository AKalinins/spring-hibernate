package com.example;

import com.example.domain.Animal;
import com.example.domain.Cat;
import com.example.domain.Dog;
import com.example.domain.Food;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyXMLConfDemoApp {

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
        System.out.println(dog.play());
        System.out.println(dog.eat());
        ((Dog)dog).runAfterCat();

        //Scope test
        Food dogFood1 = context.getBean("dogFood", Food.class);
        Food dogFood2 = context.getBean("dogFood", Food.class);

        System.out.println("All food are the same object = " + (dogFood1 == dogFood2));

        Animal dog2 = context.getBean("dog", Animal.class);

        System.out.println("All dogs are the same object = " + (dog == dog2));

        context.close();
    }
}
