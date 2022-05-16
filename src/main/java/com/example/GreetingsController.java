package com.example;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Consumes;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;

import javax.validation.Valid;

@Controller
public class GreetingsController {

    @Post
    @Consumes(MediaType.APPLICATION_JSON)
    public HttpResponse<String> greetings(@Valid @Body HelloWorldRequest request) {
        return HttpResponse.ok(request.getGreeting());
    }
}
