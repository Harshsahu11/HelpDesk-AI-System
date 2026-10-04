<h1> Backend</h1>

# 🤖 Help Desk AI Assistant — Backend

A Spring Boot backend for an AI-powered Help Desk Assistant using **Spring AI, Google Gemini, MySQL, Chat Memory, Tool Calling, and Email Notification**.

## 🚀 Features

- AI-powered help desk conversation using Google Gemini
- Conversation memory using `conversationId`
- Create, retrieve, and update support tickets
- Check existing tickets using user email
- Current date/time tool
- Automatic Spring AI tool calling
- Email notification to the support team for new tickets
- MySQL database persistence using Spring Data JPA
- System prompt loaded from a resource file

## 🛠️ Tech Stack

- Java
- Spring Boot
- Spring AI
- Google Gemini
- Spring Data JPA
- MySQL
- Lombok
- Maven

## 🏗️ Backend Flow

```text
User / Frontend
      ↓
AIController
      ↓
AIServiceImpl
      ↓
ChatClient (Spring AI)
      ├── System Prompt
      ├── Chat Memory
      └── Tools
           ├── TicketDatabaseTool
           └── EmailTool
      ↓
Google Gemini
      ↓
Tool Calling
      ↓
TicketService / Email Service
      ↓
MySQL / Support Team
      ↓
Final AI Response

```

## Control Flow
<img width="1672" height="941" alt="Spring AI Help Desk Backend Flow" src="https://github.com/user-attachments/assets/06828c4a-88e8-4785-96d8-72f5999f95c0" />


<img width="1311" height="831" alt="image" src="https://github.com/user-attachments/assets/9065a705-2236-4739-a5bc-cd41eea067e5" />


## ⚙️Configuration

  GEMINI_API_KEY=your_api_key

  ```
spring:
  application:
    name: help-desk-backend

  ai:
    google:
      genai:
        api-key: ${GEMINI_API_KEY}
        chat:
          model: gemini-3.5-flash

  datasource:
    url: jdbc:mysql://localhost:3306/help_desk_ai
    username: root
    password: root

  jpa:
    hibernate:
      ddl-auto: update

server:
  port: 8081

```


  
