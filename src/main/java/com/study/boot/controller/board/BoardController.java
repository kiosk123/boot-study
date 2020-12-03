package com.study.boot.controller.board;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/boards")
@Slf4j
public class BoardController {
    
    @GetMapping
    public String list() {
        log.debug("called list()");
        return "boards/list";
    }
}
