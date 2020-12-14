package com.study.boot.vo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

/**
 * Paging 처리 값 세팅을 위한 VO
 * @author USER
 *
 */
public class PageVO {
    
    private static final int DEFAULT_SIZE = 10;
    private static final int DEFAULT_MAX_SIZE = 50;
    
    private int page;
    private int size;
    
    public PageVO() {
        this.page = 1;
        this.size = DEFAULT_SIZE;
    }
    
    public int getPage() {
        return page;
    }
    
    public void setPage(int page) {
        this.page = page < 0 ? 1 : page;
    }
    
    public void setSize(int size) {
        this.size = size < DEFAULT_SIZE || size > DEFAULT_MAX_SIZE ? DEFAULT_SIZE : size;
    }
    
    /**
     * PageVO 정보를 이용해서 Pageable 인스턴스를 생성한다.
     * @param direction 0 내림차순, 그외 오름차순
     * @param props 정렬대상 프로퍼티
     * @return
     */
    public Pageable makePageable(int direction, String... props) {
        Sort.Direction dir = direction == 0? Sort.Direction.DESC : Sort.Direction.ASC;
        return PageRequest.of(this.page - 1, this.size, dir, props);
    }
}
