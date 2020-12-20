package com.study.boot.controller.board;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.study.boot.domain.Board;
import com.study.boot.dto.BoardDTO;
import com.study.boot.service.BoardService;
import com.study.boot.vo.PageMaker;
import com.study.boot.vo.PageVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/boards")
@Slf4j
public class BoardController {
 
    @Autowired
    private BoardService boardService;
    
    @GetMapping
    public String list(PageVO page, Model model) {
        Page<BoardDTO> result = boardService.searchBoards(page.getType(), page.getKeyword(), page.makePageable(0, "bno"));
        model.addAttribute("result", new PageMaker<>(result));
        model.addAttribute("pageVO", page);

        return "boards/list";
    }
}
