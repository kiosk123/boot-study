package com.study.boot.service;

import java.util.Optional;

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
        return result.map(board -> new BoardDTO(board.getBno(), 
                                                board.getTitle(), 
                                                board.getWriter(), 
                                                board.getContent(), 
                                                board.getCreatedDate(), 
                                                board.getUpdatedDate()));
    }
    
    @Transactional
    public void save(BoardDTO boardDTO) {
        Board board = new Board(boardDTO.getTitle(), boardDTO.getWriter(), boardDTO.getContent());
        boardRepository.save(board);
    }
    
    @Transactional
    public void updateBoard(BoardDTO boardDTO) {
        //findByBno(boardDTO.getBno())
    }
    
    public Optional<BoardDTO> findByBno(Long bno) {
        Optional<Board> opt = boardRepository.findById(bno);
        if (opt.isPresent()) {
            Board board = opt.get();
            BoardDTO boardDTO = new BoardDTO(board.getBno(), 
                                             board.getTitle(), 
                                             board.getWriter(), 
                                             board.getContent(), 
                                             board.getCreatedDate(), 
                                             board.getUpdatedDate());
            return Optional.of(boardDTO);
        }
        else {
            return Optional.empty();
        }
    }
}
