package com.study.boot.controller.board;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/boards")
@Slf4j
public class BoardController {
    
    @GetMapping
    public String list(@PageableDefault(direction = Direction.DESC,
                                        sort = "bno",
                                        size = 20,
                                        page = 0)Pageable pageable) {
        log.debug("called list()");
        return "boards/list";
    }
}
