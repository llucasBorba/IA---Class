package com.Ia.Project.controller;

import com.Ia.Project.Api.GPT;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class controller {

    GPT gpt;

    public controller(GPT gpt) {
        this.gpt = gpt;
    }

    @PostMapping("/Response")
    public List<String> response(@RequestBody String message){

        return gpt.iaResponse(message);
    }

    @GetMapping("/test")
    public String test(){
        return "Hello world";
    }
}

