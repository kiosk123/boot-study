package com.study.boot.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.study.boot.domain.Board;
import com.study.boot.dto.BoardDTO;
import com.study.boot.repository.BoardRepository;
import com.study.boot.repository.querydsl.BoardQueryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class BoardService {
    
    private final BoardRepository boardRepository;
    private final BoardQueryRepository boardQueryRepository;
    
    public Page<BoardDTO> searchBoards(String type, String keyword, Pageable pageable) { 
        Page<Board> result = boardQueryRepository.searchBoards(type, keyword, pageable);
        return result.map(board -> new BoardDTO(board.getTitle(), board.getWriter(), board.getContent()));
    }
    
    public void save(BoardDTO boardDTO) {
        //TODO 저장 처리
//        boardRepository.save(entity);
    }
}
