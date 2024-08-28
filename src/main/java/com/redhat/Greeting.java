package com.redhat;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Entity;

@Entity
public class Greeting extends PanacheEntity {

    String name;

    String message;

    public Greeting() {
    }

    public Greeting(String name, String message) {
        this.name = name;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Greeting{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public String getMessage() {
        return message;
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setMessage(String message) {
        this.message = message;
    }
}
