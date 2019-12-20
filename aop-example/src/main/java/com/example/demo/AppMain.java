package com.example.demo;

import com.example.demo.config.AppConfig;
import com.example.demo.dao.AccountDAO;
import com.example.demo.dao.MembershipDAO;
import com.example.demo.domain.Athlete;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppMain {

    public static void main(String[] args) throws InterruptedException {

        AnnotationConfigApplicationContext applicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);

        AccountDAO accountDAO = applicationContext.getBean("accountDAO", AccountDAO.class);
        MembershipDAO membershipDAO = applicationContext.getBean("membershipDAO", MembershipDAO.class);

        //Add account example
        accountDAO.addAccount();
        membershipDAO.addAccount();
        accountDAO.setLastMethodCalled("addAccount"); //Method excluded from logging
        System.out.println();

        //Add member example
        accountDAO.addMember();
        membershipDAO.addMember("Member Name");
        String s = accountDAO.getLastMethodCalled(); //Method excluded from logging
        System.out.println();

        try {
            membershipDAO.addCat("Moew");
        } catch (RuntimeException rte) {
            System.out.println("Message in catch block: " + rte.getMessage());
        }

        System.out.println();
        Athlete athlete = applicationContext.getBean("athlete", Athlete.class);
        System.out.println(athlete.run(false));
        System.out.println();
        System.out.println(athlete.run(true));

        applicationContext.close();
    }
}
