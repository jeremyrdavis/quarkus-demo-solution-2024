package com.redhat;

import jakarta.enterprise.context.ApplicationScoped;

import java.util.ArrayList;
import java.util.List;

@ApplicationScoped
public class GreetingGenerator {

    List<String> greetings = new ArrayList<>(){{
        add("Hello");
        add("Hi");
        add("Good morning");
    }};

    public String generateGreeting(String name) {
        return greetings.get((int) (Math.random() * greetings.size())) + " " + name + "!";
    }
}
