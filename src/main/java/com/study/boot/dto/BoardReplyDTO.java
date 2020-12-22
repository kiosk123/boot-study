package com.study.boot.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
public class BoardReplyDTO {
    private Long rno;
    private String replyText;
    private String replyer;
    
    public BoardReplyDTO(Long rno, String replyText, String replyer) {
        this.rno = rno;
        this.replyText = replyText;
        this.replyer = replyer;
    }
}
