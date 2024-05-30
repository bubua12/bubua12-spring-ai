package com.bubua12.ai.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ai.openai.OpenAiChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.Map;

/**
 *
 *
 * @author bubua12
 * @since 2024/5/30 18:06
 */
@Slf4j
@RestController
public class OpenAIController {


    private final OpenAiChatModel chatModel;

    @Autowired
    public OpenAIController(OpenAiChatModel chatModel) {
        this.chatModel = chatModel;
    }

    /**
     * 返回Map的格式
     *
     * @param message
     * @return
     */
    @GetMapping("/ai/generate")
    public Map generate(@RequestParam(value = "message",
            defaultValue = "讲个笑话") String message) {

        String answer = chatModel.call(message);
        log.info("answer: {}", answer);

        return Map.of("generation", answer);
    }

    /**
     * 返回Flux数据流
     *
     * @param message
     * @return
     */
    @GetMapping(value = "/ai/generateStream")
    public Flux<String> generateStream(@RequestParam(value = "message",
            defaultValue = "讲个笑话") String message) {
//        Prompt prompt = new Prompt(new UserMessage(message));
        Flux<String> stream = chatModel.stream(message);

        log.info("ai stream answer: {}", stream);

        return stream;
    }
}
