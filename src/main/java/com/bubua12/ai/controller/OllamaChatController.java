package com.bubua12.ai.controller;

import org.springframework.ai.ollama.OllamaChatModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

/**
 * 本地模型Ollama Chat Controller
 *
 * @author bubua12
 * @since 2024/5/30 18:53
 */
@RestController
public class OllamaChatController {

    private final OllamaChatModel ollamaChatModel;

    @Autowired
    public OllamaChatController(OllamaChatModel ollamaChatModel) {
        this.ollamaChatModel = ollamaChatModel;
    }


}
