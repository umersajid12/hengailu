package com.hengailu.backend.chat.api.service;

import com.hengailu.backend.chat.api.model.ChatMessage;
import com.hengailu.backend.chat.api.repository.ChatMessageRepository;

import org.springframework.stereotype.Service;

@Service
public class ChatMessageService {
    private final ChatMessageRepository chatMessageRepository;

    public ChatMessageService(ChatMessageRepository chatMessageRepository) {
        this.chatMessageRepository = chatMessageRepository;
    }

    public void saveChatMessage(ChatMessage message){
        chatMessageRepository.save(message);
    }
}
