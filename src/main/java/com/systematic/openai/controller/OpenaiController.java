package com.systematic.openai.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.systematic.openai.dto.OpenaiRequest;
import com.systematic.openai.dto.OpenaiResponse;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/bot")
public class OpenaiController {

	@Value("${openai.model}")
	private String model;

	@Value(("${openai.api.url}"))
	private String apiURL;

	@Autowired
	private RestTemplate template;

	@GetMapping("/chat")
	public String chat(@RequestParam("prompt") String prompt) {
		OpenaiRequest request = new OpenaiRequest(model, prompt);
		OpenaiResponse openaiResponse = template.postForObject(apiURL, request, OpenaiResponse.class);
		log.info(openaiResponse.toString());
		return openaiResponse.getChoices().get(0).getMessage().getContent();
	}
}