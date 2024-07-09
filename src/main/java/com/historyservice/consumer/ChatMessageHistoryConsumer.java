package com.historyservice.consumer;

import com.historyservice.dao.ChatMessageDAO;
import com.historyservice.dto.ChatMessageDTO;
import com.historyservice.entities.ChatMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * Author: harjeevansingh
 */

@Component
public class ChatMessageHistoryConsumer {

    @Autowired
    private ChatMessageDAO chatMessageDAO;

    @KafkaListener(topics = "history_messages", groupId = "history-service")
    public void consumeChatMessage(ChatMessageDTO messageDTO) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setConversationId(messageDTO.getConversationId());
        chatMessage.setUserId(messageDTO.getUserId());
        chatMessage.setContent(messageDTO.getContent());
        chatMessage.setSenderType(messageDTO.getSenderType());
        chatMessage.setTimestamp(messageDTO.getTimestamp());
        chatMessageDAO.save(chatMessage);
    }
}
