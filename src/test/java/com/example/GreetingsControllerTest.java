package com.example;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@MicronautTest
class GreetingsControllerTest {

    @Inject
    @Client("/")
    HttpClient client;


    @Test
    void thatViolationsAreSerializedOnConstraintViolations() {
        var e = assertThrows(HttpClientResponseException.class,
                () -> client.toBlocking().exchange(HttpRequest.POST("/", new HelloWorldRequest()))
        );

        var expected = "{\"type\":\"https://zalando.github.io/problem/constraint-violation\",\"title\":\"Constraint Violation\",\"status\":400,\"violations\":[{\"field\":\"greeting\",\"message\":\"must not be blank\"}]}";
        assertEquals(expected, e.getResponse().getBody(String.class).get());

    }


}