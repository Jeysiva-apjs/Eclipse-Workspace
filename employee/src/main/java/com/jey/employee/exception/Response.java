package com.jey.employee.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Response {
	
	LocalDateTime time;
	List<String> messages;
	
	public Response() {
		this.time = LocalDateTime.now();
		this.messages = new ArrayList<String>();
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}
	
}
