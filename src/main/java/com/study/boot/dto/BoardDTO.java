package com.study.boot.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter @Getter
@ToString
public class BoardDTO {
    private Long bno;
    private String title;
    private String writer;
    private String content;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;
}
