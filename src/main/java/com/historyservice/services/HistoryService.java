package com.historyservice.services;

/**
 * Author: harjeevansingh
 */

import com.historyservice.dto.ChatMessageDTO;
import com.historyservice.entities.ChatMessage;
import com.historyservice.dao.ChatMessageDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class HistoryService {

    @Autowired
    private ChatMessageDAO chatMessageDAO;

    @KafkaListener(topics = "chat_messages", groupId = "history-service")
    public void consumeChatMessage(ChatMessageDTO messageDTO) {
        ChatMessage chatMessage = new ChatMessage();
        chatMessage.setConversationId(messageDTO.getConversationId());
        chatMessage.setUserId(messageDTO.getUserId());
        chatMessage.setContent(messageDTO.getContent());
        chatMessage.setSenderType(messageDTO.getSenderType());
        chatMessage.setTimestamp(messageDTO.getTimestamp());
        chatMessageDAO.save(chatMessage);
    }

    public Page<ChatMessageDTO> getChatHistory(Long conversationId, int page, int size) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "timestamp"));
        Page<ChatMessage> messagePage = chatMessageDAO.findByConversationIdOrderByTimestampDesc(conversationId, pageable);
        return messagePage.map(this::convertToDTO);
    }

    private ChatMessageDTO convertToDTO(ChatMessage chatMessage) {
        ChatMessageDTO dto = new ChatMessageDTO();
        dto.setId(chatMessage.getId());
        dto.setConversationId(chatMessage.getConversationId());
        dto.setUserId(chatMessage.getUserId());
        dto.setContent(chatMessage.getContent());
        dto.setSenderType(chatMessage.getSenderType());
        dto.setTimestamp(chatMessage.getTimestamp());
        return dto;
    }
}
