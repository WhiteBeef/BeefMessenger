package ru.whitebeef.beefmessenger.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.whitebeef.beefmessenger.entities.Chat;

public interface ChatMessageRepository extends JpaRepository<Chat, Long> {


}
