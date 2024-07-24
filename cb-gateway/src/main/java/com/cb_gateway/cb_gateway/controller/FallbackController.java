package com.cb_gateway.cb_gateway.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FallbackController {

    @GetMapping("/inCaseOfFailureUseThis")
    public String fallback() {
        return "This is a fallback response.";
    }
}
