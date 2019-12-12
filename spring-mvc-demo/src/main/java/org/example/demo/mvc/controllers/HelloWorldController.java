package org.example.demo.mvc.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class HelloWorldController {

    @RequestMapping("/form")
    public String showForm() {
        return "hello-world-form";
    }

    @RequestMapping("/processForm")
    public String processForm() {
        return "hello-world";
    }

    @RequestMapping("/processFormVersionTwo")
    public String dataModelProcessing(HttpServletRequest request, Model model) {

        String name = request.getParameter("name");

        name = "Name from request: " + name;

        model.addAttribute("message", name);
        return "hello-world";
    }

    @RequestMapping("/processFormVersionThree")
    public String bindingRequestParam(@RequestParam("name") String name, Model model) {

        name = "Name from request parameter binding: " + name;

        model.addAttribute("message", name);
        return "hello-world";
    }
}
