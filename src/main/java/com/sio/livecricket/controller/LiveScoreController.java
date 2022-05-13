package com.sio.livecricket.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LiveScoreController {
    @GetMapping()
    public String score() {
        /*classpath:/templates/score/index*/
        return "score/index";
    }
}
