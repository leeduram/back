package com.bzip.project.dto;

public class PostPaginationRequestDTO {
    private int page; // 현재 페이지 번호
    private int limit; // 한 페이지에 보여줄 게시글 수

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }
}
