package com.historyservice.controllers.v1;

/**
 * Author: harjeevansingh
 */

import com.historyservice.dto.ChatMessageDTO;
import com.historyservice.services.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/history")
public class HistoryController {

    @Autowired
    private HistoryService historyService;

    @GetMapping("/{conversationId}")
    public ResponseEntity<Page<ChatMessageDTO>> getChatHistory(
            @PathVariable Long conversationId,
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "20") int size) {
        Page<ChatMessageDTO> chatHistory = historyService.getChatHistory(conversationId, page, size);
        return ResponseEntity.ok(chatHistory);
    }
}
