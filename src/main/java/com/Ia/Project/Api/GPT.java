package com.Ia.Project.Api;


import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GPT {

    @Value(value = "${openai.model}")
    private String model;


    OpenAiService service = new OpenAiService("d");


    public List<String> iaResponse(String message){

        try{

            CompletionRequest request = CompletionRequest.builder()
                    .model(model)
                    .prompt(message)
                    .maxTokens(100)
                    .build();

            List<CompletionChoice> gptResponseCompletion = service.createCompletion(request).getChoices();

            List<String> gptResponse = gptResponseCompletion.stream()
                    .map(CompletionChoice::getText)
                    .collect(Collectors.toList());

            return gptResponse;
        }catch (Exception e ){
                    List<String> test = new ArrayList<>();
                    test.add(e.getMessage());
                    return test;

        }

    }
}