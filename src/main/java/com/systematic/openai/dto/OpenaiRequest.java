package com.systematic.openai.dto;


import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class OpenaiRequest {

	private String model;
	private List<Message> messages;

	public OpenaiRequest(String model, String prompt) {
	        this.model = model;
	        this.messages = new ArrayList<>();
	        this.messages.add(new Message("user",prompt));
	    }
}
