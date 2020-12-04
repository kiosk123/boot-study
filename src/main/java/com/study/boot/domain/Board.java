package com.study.boot.domain;

import javax.jdo.annotations.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.study.boot.domain.base.BaseTimeEntity;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "TBL_BOARDS")
public class Board extends BaseTimeEntity {
    
    @Id @GeneratedValue
    @Column(name = "BOARD_ID")
    private Long bno;
    
    @Setter
    private String title;
    
    @Setter
    private String writer;
    
    @Setter
    private String content;

    public Board(String title, String writer, String content) {
        this.title = title;
        this.writer = writer;
        this.content = content;
    }
}
