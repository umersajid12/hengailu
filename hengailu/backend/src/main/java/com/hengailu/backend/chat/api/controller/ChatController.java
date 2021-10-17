package com.hengailu.backend.chat.api.controller;

import com.hengailu.backend.appuser.AppUserService;
import com.hengailu.backend.chat.api.model.ChatMessage;
import com.hengailu.backend.chat.api.service.ChatMessageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {
    @Autowired
    private AppUserService appUserService;
    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;
    @Autowired
    private ChatMessageService chatMessageService;

    /*@MessageMapping("/chat.register")
    @SendTo("/topic/public")
    public ChatMessage register(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", chatMessage.getSender());
        return chatMessage;

    }*/

    @MessageMapping("/chat/{to}")
    public void sendMessage(@DestinationVariable String to, @Payload ChatMessage chatMessage) {
        boolean senderExists = appUserService.senderExists(chatMessage.getSender().getEmail());
        if (!senderExists) {
            throw new IllegalStateException("sender doesnt exist");
        }
        simpMessagingTemplate.convertAndSend("/topic/messages" + to, chatMessage);
        chatMessageService.saveChatMessage(chatMessage);
    }

    /*@RequestMapping("/index")
    public String start() {
        return "index";
    }*/
}
