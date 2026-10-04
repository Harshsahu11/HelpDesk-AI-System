package com.detrox.helpdesk.help_desk_backend.serviceImpl;

import com.detrox.helpdesk.help_desk_backend.service.AIService;
import com.detrox.helpdesk.help_desk_backend.tools.TicketDatabaseTool;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIServiceImpl implements AIService {

    private final ChatClient chatClient;

    private final TicketDatabaseTool ticketDatabaseTool;

    @Override
    public String getResponsefromAssistant(String query){
        return this.chatClient
                .prompt()
                .tools(ticketDatabaseTool)
                .user(query)
                .call()
                .content();
    }
}
