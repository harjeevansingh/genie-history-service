# Genie Chat Bot - History Service

## Project Description
Genie Chat Bot is an AI-powered chatbot system providing instant lending-related query resolution. It supports multiple concurrent user sessions with real-time responses and comprehensive conversation history storage. The system is built using a microservices architecture for scalability and efficient query resolution.

## History Service Description
The History Service is responsible for storing and retrieving the complete conversation history. It uses MongoDB for efficient storage and retrieval of chat messages, allowing for comprehensive record-keeping and data analysis.

## Dependencies
Before running the History Service, ensure the following repository is cloned and its service is running:
- Chat Service: https://github.com/harjeevansingh/genie-chat-service

## Prerequisites
- Docker and Docker Compose installed on your system
- Port 27017 (MongoDB) should be available
- Chat Service should be up and running

## Steps to Run
1. Navigate to the History Service directory:
      cd /path/to/genie-history-service
2. Start the service:
      docker-compose up
3. Verify that the service is running:
      docker ps

For full deployment of the Genie Chat Bot system, refer to the main deployment guide.
   https://docs.google.com/document/d/1UWd703j5do7ilt7zrmmJodJIY9KydrCAX3lkqXyKH2w/edit