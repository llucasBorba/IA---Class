package com.Ia.Project.Api;


import com.theokanning.openai.completion.CompletionChoice;
import com.theokanning.openai.completion.CompletionRequest;
import com.theokanning.openai.service.OpenAiService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GPT {

    String apikey;
    public GPT(@Value("${api.key}") String apikey) {
        this.apikey = apikey;
    }

    OpenAiService service = new OpenAiService("");


    public List<String> iaResponse(String message){

        try{

            CompletionRequest request = CompletionRequest.builder()
                    .model("GPT-3.5 Turbo")
                    .prompt(message)
                    .maxTokens(100)
                    .build();

            List<CompletionChoice> gptResponseCompletion = service.createCompletion(request).getChoices();

            List<String> gptResponse = gptResponseCompletion.stream()
                    .map(CompletionChoice::getText)
                    .collect(Collectors.toList());

            return gptResponse;
        }catch (Exception e ){
            return null;
        }

    }
}