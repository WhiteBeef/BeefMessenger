package ru.whitebeef.beefmessenger.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.whitebeef.beefmessenger.entities.Chat;
import ru.whitebeef.beefmessenger.entities.ChatMessage;
import ru.whitebeef.beefmessenger.entities.User;
import ru.whitebeef.beefmessenger.exceptions.NoPermissionException;
import ru.whitebeef.beefmessenger.repository.ChatRepository;


@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    @Transactional
    public void sendMessage(User sender, Chat chat, String message) {

        if (!chat.getUsers().contains(sender)) {
            throw new NoPermissionException("No permission to send messages to this chat!");
        }

        chat.addMessage(new ChatMessage(chat, message));

        chatRepository.save(chat);

    }

}
