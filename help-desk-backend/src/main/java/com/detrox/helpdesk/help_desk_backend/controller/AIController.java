package com.detrox.helpdesk.help_desk_backend.controller;

import com.detrox.helpdesk.help_desk_backend.service.AIService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ai")
@RequiredArgsConstructor
public class AIController {

    private final AIService aiService;

    @PostMapping
    public ResponseEntity<String> getResponse(@RequestBody String query,
                                              @RequestHeader("conversationId") String conversationId){
        return ResponseEntity.ok(aiService.getResponsefromAssistant(query,conversationId));
    }

}
