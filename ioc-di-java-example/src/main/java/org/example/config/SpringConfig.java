package org.example.config;

import org.example.domain.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

@Configuration
@PropertySource("classpath:properties/name.properties")
public class SpringConfig {

    @Bean
    public Animal cat() {
        return new Cat(catToy(), catFood());
    }

    @Bean
    @Scope("prototype")
    public Food catFood() {
        return new CatFood();
    }

    @Bean
    public Toy catToy() {
        return new CatToy();
    }
}
