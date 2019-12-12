package org.example.demo.mvc.controllers;

import org.example.demo.domain.User;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UserController {

    @Value("#{sexOptions}")
    private Map<String, String> sexOptions = new HashMap<>();

    @RequestMapping("/userForm")
    public String showForm(Model model) {

        User user = new User();
        model.addAttribute("user", user);
        model.addAttribute("sexOptions", sexOptions);
        return "user-form";
    }

    @RequestMapping("/processUserForm")
    public String processForm(@ModelAttribute("user") User user) {
        System.out.println("User: " + user.getFirstName() + " " + user.getLastName());
        System.out.println("Country: " + user.getCountry());
        System.out.println("Sex: " + user.getSex());
        System.out.println("Language: " + user.getLanguage());
        System.out.println("OS:" + Arrays.toString(user.getOperatingSystems()));
        return "user-confirmation";
    }
}
