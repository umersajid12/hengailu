package com.hengailu.backend.appuser.email;

public interface EmailSender {
    void send(String to, String email);
}
