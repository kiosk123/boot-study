package com.study.boot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter @Getter
@ToString
public class BoardDTO {
    private String title;
    private String writer;
    private String content;
}
