package ru.whitebeef.beefmessenger.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Entity
@NoArgsConstructor
public class Chat {
    @Id
    private Long id;

    @OneToMany
    private List<ChatMessage> messages;

    @OneToMany
    private List<User> users;


    public void addMessage(ChatMessage message) {
        messages.add(message);
    }
}
