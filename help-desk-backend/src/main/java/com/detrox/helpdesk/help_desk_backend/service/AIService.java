package com.detrox.helpdesk.help_desk_backend.service;

import reactor.core.publisher.Flux;

public interface AIService {

    String getResponsefromAssistant(String query,String conversationId);

    Flux<String> streamresponseFromAssistant(String query, String conversationId);

}
