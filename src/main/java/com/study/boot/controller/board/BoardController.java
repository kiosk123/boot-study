package com.study.boot.controller.board;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.study.boot.dto.BoardDTO;
import com.study.boot.service.BoardService;
import com.study.boot.vo.PageMaker;
import com.study.boot.vo.PageVO;

import lombok.extern.slf4j.Slf4j;

@RequestMapping("/board")
@Controller
@Slf4j
public class BoardController {
 
    @Autowired
    private BoardService boardService;
    
    @GetMapping("/list")
    public String list(PageVO page, Model model) {
        Page<BoardDTO> result = boardService.searchBoards(page.getType(), page.getKeyword(), page.makePageable(0, "bno"));
        model.addAttribute("result", new PageMaker<>(result));
        model.addAttribute("pageVO", page);

        return "boards/list";
    }
    
    @GetMapping("/register")
    public String getRegisterForm(Model model) {
        return "/boards/register";
    }
    
    @PostMapping("/register")
    public String register(BoardDTO boardDTO, RedirectAttributes rattr) {
        log.debug("create new board by post method");
        log.debug(boardDTO.toString());
        
        boardService.save(boardDTO);
        rattr.addFlashAttribute("msg", "success");
        return "redirect:/board/list";
    }
    
    @GetMapping("/view")
    public String getViewBoard(@RequestParam("bno")Long bno, PageVO page, Model model) {
        Optional<BoardDTO> opt = boardService.findByBno(bno);
        if (opt.isPresent()) {
            BoardDTO boardDTO = opt.get();
            model.addAttribute("vo", boardDTO);
            model.addAttribute("pageVO", page);
            return "/boards/view";
        } 
        else {
            return "redirect:/board/list";
        }
    }
    
    @GetMapping("/modify")
    public String getModifyForm(@RequestParam("bno")Long bno, PageVO page, Model model) {
        Optional<BoardDTO> opt = boardService.findByBno(bno);
        if (opt.isPresent()) {
            BoardDTO boardDTO = opt.get();
            model.addAttribute("vo", boardDTO);
            model.addAttribute("pageVO", page);
            return "/boards/modify";
        } 
        else {
            return "redirect:/board/list";
        }
    }
    
    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO, PageVO page, RedirectAttributes rattr) {
        Long updateCnt = boardService.updateBoard(boardDTO);
        rattr.addFlashAttribute("pageVO", page);
        if (updateCnt > 0) {
            rattr.addAttribute("bno", boardDTO.getBno());
            return "redirect:/board/view";
        }
        else {
            return "redirect:/board/list";
        }
    }
    
    @PostMapping("/delete")
    public String delete(BoardDTO boardDTO, PageVO page, RedirectAttributes rattr) {
        Long deleteCnt = boardService.deleteBoard(boardDTO.getBno());
        rattr.addFlashAttribute("pageVO", page);
        return "redirect:/board/list";
    }
}
