package com.example.controller;

import java.util.Map;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private int gameValue = 10;

    @MessageMapping("/click")
    @SendTo("/topic/message")
    public Map<String, Object> sendData(Map<String, Object> message) {
    	String contentValue = (String) message.get("click");
    	int intValue = Integer.parseInt(contentValue);
        this.gameValue -= intValue;
        if(this.gameValue<0) {
        	this.gameValue=10;
        }
        message.put("HP", gameValue);
        return message;
    }

    @MessageMapping("/getGameData")
    @SendTo("/topic/message")
    public Map<String, Object> getGameValue(Map<String, Object> message) {
    	message.put("HP", gameValue);
    	return message;
    }
    
  
}
