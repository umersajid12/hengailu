package com.hengailu.backend.chat.api.repository;

import com.hengailu.backend.chat.api.model.ChatMessage;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ChatMessageRepository extends JpaRepository<ChatMessage, Long> {
}
