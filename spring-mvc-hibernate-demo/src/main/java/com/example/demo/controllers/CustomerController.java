package com.example.demo.controllers;

import com.example.demo.domain.Customer;
import com.example.demo.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @GetMapping("/customer/list")
    public String listCustomers(Model model) {

        List<Customer> customers = customerService.getCustomers();
        model.addAttribute("customers", customers);

        return "list-customers";
    }

    @GetMapping("/customer/showFormForAdd")
    public String showFormForAdd(Model model) {

        Customer customer = new Customer();

        model.addAttribute("customer", customer);

        return "customer-form";
    }

    @PostMapping("/customer/saveCustomer")
    public String saveCustomer(@ModelAttribute("customer") Customer customer) {

        customerService.saveCustomer(customer);
        return "redirect:/customer/list";
    }

    @GetMapping("/customer/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("customerId") int customerId, Model model) {

        Customer customer = customerService.getCustomerById(customerId);

        model.addAttribute("customer", customer);
        return "customer-form";
    }

    @GetMapping("/customer/delete")
    public String deleteCustomer(@RequestParam("customerId") int customerId) {

        customerService.deleteCustomer(customerId);
        return "redirect:/customer/list";
    }
}
