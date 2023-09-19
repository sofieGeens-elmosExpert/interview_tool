package be.elmos.interview_tool_spring.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {
    @GetMapping("/index")
    public String logInPage(){
        return "index";
    }
}
