package com.detrox.helpdesk.help_desk_backend.serviceImpl;

import com.detrox.helpdesk.help_desk_backend.service.AIService;
import com.detrox.helpdesk.help_desk_backend.tools.EmailTool;
import com.detrox.helpdesk.help_desk_backend.tools.TicketDatabaseTool;
import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AIServiceImpl implements AIService {

    private final ChatClient chatClient;
    private final TicketDatabaseTool ticketDatabaseTool;
    private final EmailTool emailTool;

    @Value("classpath:/prompts/helpdesk-system.st")
    private Resource systemPromptResource;

    @Override
    public String getResponsefromAssistant(String query,String conversationId) {

        return this.chatClient
                .prompt()
                .advisors(advisorSpec -> advisorSpec
                        .param(ChatMemory.CONVERSATION_ID,conversationId))
                .tools(ticketDatabaseTool,emailTool)
                .system(systemPromptResource)
                .user(query)
                .call()
                .content();
    }
}