package com.coding.validationDemo.entity;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public class Customer {

    private String firstName;

    @NotNull(message = "is required")
    @Min(value = 1, message = "")
    private String lastName;

    public Customer() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
