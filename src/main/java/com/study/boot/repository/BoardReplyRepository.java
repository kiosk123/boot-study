package com.study.boot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.study.boot.domain.BoardReply;

public interface BoardReplyRepository  extends JpaRepository<BoardReply, Long>{

}
