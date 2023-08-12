package com.systematic.openai.dto;


import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.ALWAYS)
public class OpenaiRequest {

	private String model;
	private List<Message> messages;

	public OpenaiRequest(String model, String prompt) {
	        this.model = model;
	        this.messages = new ArrayList<>();
	        this.messages.add(new Message("user",prompt));
	    }
}
