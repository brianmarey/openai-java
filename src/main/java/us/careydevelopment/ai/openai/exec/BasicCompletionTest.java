package us.careydevelopment.ai.openai.exec;

import com.theokanning.openai.completion.chat.ChatCompletionRequest;
import com.theokanning.openai.completion.chat.ChatMessage;
import com.theokanning.openai.completion.chat.ChatMessageRole;
import com.theokanning.openai.service.OpenAiService;
import us.careydevelopment.ai.openai.support.OpenAiServiceHelper;

import java.util.ArrayList;
import java.util.List;

public class BasicCompletionTest {
    public static void main(String[] args) {
        final List<ChatMessage> messages = getMessages();

        final OpenAiService service = OpenAiServiceHelper.getOpenAiService();

        final ChatCompletionRequest chatCompletionRequest = ChatCompletionRequest
                .builder()
                .model("gpt-3.5-turbo-0613")
                .messages(messages)
                .build();

        service.createChatCompletion(chatCompletionRequest)
                .getChoices()
                .forEach(System.out::println);
    }

    private static List<ChatMessage> getMessages() {
        final List<ChatMessage> messages = new ArrayList<>();
        final ChatMessage systemMessage = new ChatMessage(ChatMessageRole.SYSTEM.value(), "You are a helpful assistant.");
        final ChatMessage userMessage = new ChatMessage(ChatMessageRole.USER.value(), "What is the best tool for API testing?");

        messages.add(systemMessage);
        messages.add(userMessage);

        return messages;
    }
}
