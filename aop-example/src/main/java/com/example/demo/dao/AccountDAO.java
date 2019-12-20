package com.example.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class AccountDAO {

    private String lastMethodCalled;

    public void addAccount() {
        System.out.println("Some database process here using addAccount() " + getClass());
    }

    public void addMember() {
        System.out.println("Some database process here using addMember() " + getClass());
    }

    public String getLastMethodCalled() {
        System.out.println("Getter method fired in class " + getClass());
        return lastMethodCalled;
    }

    public void setLastMethodCalled(String lastMethodCalled) {
        System.out.println("Setter method fired in class " + getClass());
        this.lastMethodCalled = lastMethodCalled;
    }
}
