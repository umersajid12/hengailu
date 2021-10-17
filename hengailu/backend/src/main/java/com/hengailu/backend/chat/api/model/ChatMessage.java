package com.hengailu.backend.chat.api.model;

import com.hengailu.backend.appuser.AppUser;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class ChatMessage {
    @Id
    @SequenceGenerator(name = "chat_sequence",
            sequenceName = "chat_sequence",
            allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "chat_sequence")
    private Long id;
    private String content;
    @ManyToOne
    private AppUser sender;
    @ManyToOne
    private AppUser receiver;
    private MessageType type;

    public ChatMessage(String content, AppUser sender, AppUser receiver, MessageType type) {
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
        this.type = type;
    }

    public enum MessageType {
        CHAT, LEAVE, JOIN
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public AppUser getSender() {
        return sender;
    }

    public void setSender(AppUser sender) {
        this.sender = sender;
    }

    public MessageType getType() {
        return type;
    }

    public void setType(MessageType type) {
        this.type = type;
    }

    public AppUser getReceiver() {
        return receiver;
    }

    public void setReceiver(AppUser receiver) {
        this.receiver = receiver;
    }
}
