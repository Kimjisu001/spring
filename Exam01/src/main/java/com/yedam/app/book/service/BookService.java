package com.yedam.app.book.service;

import java.util.List;

public interface BookService {
//도서목록조회
	public List<BookVO> bookList();
//책 등록
	public int insertBook(BookVO bookVO); 
}
