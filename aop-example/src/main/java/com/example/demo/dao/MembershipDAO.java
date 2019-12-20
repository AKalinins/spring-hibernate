package com.example.demo.dao;

import org.springframework.stereotype.Component;

@Component
public class MembershipDAO {

    public void addAccount() {
        System.out.println("Some database process here using addAccount() " + getClass());
    }

    public void addMember(String string) {
        System.out.println("Some database process here using addMember() " + getClass() + ". Member name: " + string);
    }

    public void addCat(String cat) {
        throw new UnsupportedOperationException("Cats cannot be members of our club");
    }
}
