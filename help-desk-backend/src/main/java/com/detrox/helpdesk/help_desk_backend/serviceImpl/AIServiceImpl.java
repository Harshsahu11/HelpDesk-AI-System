package com.detrox.helpdesk.help_desk_backend.serviceImpl;

import com.detrox.helpdesk.help_desk_backend.service.AIService;
import com.detrox.helpdesk.help_desk_backend.tools.TicketDatabaseTool;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIServiceImpl implements AIService {

    private final ChatClient chatClient;
    private final TicketDatabaseTool ticketDatabaseTool;

    @Value("classpath:/prompts/helpdesk-system.st")
    private Resource systemPromptResource;

    @Override
    public String getResponsefromAssistant(String query) {

        return this.chatClient
                .prompt()
                .tools(ticketDatabaseTool)
                .system(systemPromptResource)
                .user(query)
                .call()
                .content();
    }
}