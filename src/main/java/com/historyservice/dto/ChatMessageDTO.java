package com.historyservice.dto;

/**
 * Author: harjeevansingh
 */

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatMessageDTO {
    private String id;
    private Long conversationId;
    private Long userId;
    private String content;
    private String senderType;
    private LocalDateTime timestamp;
}
