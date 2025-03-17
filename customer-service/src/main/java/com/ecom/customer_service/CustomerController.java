package com.ecom.customer_service;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/api")
@RestController
public class CustomerController {

    RestTemplate rest;

    @GetMapping("/customers")
    public List<String> getCustomers(){
        String[] names= {"Atasi", "Joanisa", "Sushree"};
        List<String> namelist = Arrays.stream(names)
        .collect(Collectors.toList());
        return namelist;
    }

    @GetMapping("/products")
    public List<String> getUserData(){
       rest = new RestTemplate();
        return rest.getForObject("http://localhost:5555/api/products", List.class);
    }
}
    


