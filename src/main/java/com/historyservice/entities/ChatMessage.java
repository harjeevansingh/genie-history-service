package com.historyservice.entities;

/**
 * Author: harjeevansingh
 */

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Data
@Document(collection = "chat_messages")
public class ChatMessage {
    @Id
    private String id;
    private Long conversationId;
    private Long userId;
    private String content;
    private String senderType;
    private LocalDateTime timestamp;
}
