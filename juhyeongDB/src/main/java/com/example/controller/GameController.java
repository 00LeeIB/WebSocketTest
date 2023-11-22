package com.example.controller;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class GameController {

    private int gameValue = 10;

    @MessageMapping("/updateValue")
    @SendTo("/topic/gameValue")
    public int updateValue(int newValue) {
        this.gameValue -= newValue;
        if(this.gameValue==0) {
        	this.gameValue=10;
        }
        return this.gameValue;
    }

    // 새로운 엔드포인트 추가
    @MessageMapping("/getGameValue")
    @SendTo("/topic/gameValue")
    public int getGameValue() {
        return this.gameValue;
    }
  
}
