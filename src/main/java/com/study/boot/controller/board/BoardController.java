package com.study.boot.controller.board;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.boot.dto.BoardDTO;
import com.study.boot.service.BoardService;
import com.study.boot.vo.PageMaker;
import com.study.boot.vo.PageVO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class BoardController {
 
    @Autowired
    private BoardService boardService;
    
    @GetMapping("/boards")
    public String list(PageVO page, Model model) {
        Page<BoardDTO> result = boardService.searchBoards(page.getType(), page.getKeyword(), page.makePageable(0, "bno"));
        model.addAttribute("result", new PageMaker<>(result));
        model.addAttribute("pageVO", page);

        return "boards/list";
    }
    
    @GetMapping("/board")
    public String getBoardForm(Long bno, Model model) {
        log.debug("get board form");
        
        if (Objects.isNull(bno)) {
            model.addAttribute("method", "POST");
            return "/boards/register";
        }
        else {
            // 수정시 게시물 처리...
            model.addAttribute("method", "PUT");
            return "/boards/modify";
        }
    }
    
    @PostMapping("/board")
    public String register(BoardDTO boardDTO, RedirectAttributes rattr) {
        log.debug("create new board by post method");
        log.debug(boardDTO.toString());
        
        boardService.save(boardDTO);
        rattr.addFlashAttribute("msg", "success");
        return "redirect:/boards";
    }
}
