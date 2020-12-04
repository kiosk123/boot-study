package com.study.boot.repository.querydsl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.query.JpaCountQueryCreator;
import org.springframework.stereotype.Repository;

import com.querydsl.core.BooleanBuilder;
import com.study.boot.domain.Board;
import com.study.boot.repository.querydsl.base.Querydsl4Repository;
import static com.study.boot.domain.QBoard.*;

@Repository
public class BoardQueryRepository extends Querydsl4Repository {

    public BoardQueryRepository() {
        super(Board.class);
    }
    
    public Page<Board> searchBoards(String type, String keyword, Pageable pageable) {
        return applyPagination(pageable, query -> {
            return query.selectFrom(board).where(searchCondtion(type, keyword));
        }, countQuery -> {
            return countQuery.selectFrom(board).where(searchCondtion(type, keyword));
        });
    }
    
    private BooleanBuilder searchCondtion(String type, String keyword) {
        BooleanBuilder builder = new BooleanBuilder();
        switch (type.toLowerCase()) {
        case "t":
            builder.and(board.title.lower().like("%" + keyword.toLowerCase() + "%"));
            break;

        case "c":
            builder.and(board.content.lower().like("%" + keyword.toLowerCase() + "%"));
            break;
            
        case "w":
            builder.and(board.writer.lower().like("%" + keyword.toLowerCase() + "%"));
            break;
        }
        return builder;
    }
}
