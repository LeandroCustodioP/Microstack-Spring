package com.microstack.demoservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    @Value("${custom.message:Mensagem padrão (fallback)}")
    private String message;

    @GetMapping("/message")
    public String message() {
        return message;
    }
}
