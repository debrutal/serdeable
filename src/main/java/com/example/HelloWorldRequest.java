package com.example;

import io.micronaut.serde.annotation.Serdeable;

import javax.validation.constraints.NotBlank;

@Serdeable
public class HelloWorldRequest {
    @NotBlank
    String greeting;

    public String getGreeting() {
        return greeting;
    }
}
