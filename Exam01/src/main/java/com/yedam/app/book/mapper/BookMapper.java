package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;

public interface BookMapper {
    //전체조회
	public List<BookVO> selectBookAll();
	
	//등록
	public int insertBookInfo(BookVO bookVO);
	
	//도서대여현황 조회
	public List<BookVO> Bookall();
	
}
