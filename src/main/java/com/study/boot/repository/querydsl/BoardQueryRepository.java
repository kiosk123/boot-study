package com.study.boot.repository.querydsl;

import org.springframework.stereotype.Repository;

import com.study.boot.domain.Board;
import com.study.boot.repository.querydsl.base.Querydsl4Repository;

@Repository
public class BoardQueryRepository extends Querydsl4Repository {

    public BoardQueryRepository() {
        super(Board.class);
    }
}
