package ru.whitebeef.beefmessenger.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class ChatMessage {


    @Id
    private Long id;

    @ManyToOne
    private Chat chat;

    private String message;

    public ChatMessage(Chat chat, String message) {
        this.chat = chat;
        this.message = message;
    }
}
