package com.microstack.demoservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class DemoController {

    @Value("${info.app:DemoService}")
    private String appInfo;

    @GetMapping("/hello")
    String hello() {
        return "Hello from " + appInfo;
    }
}
