package com.yedam.app.book.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;


@Service //어노테이션, 실제 기능을 구현 클래스
//어떤 기능을 만드느냐에 따라서 다달라짐. 
//@AllArgsConstructor //현재 클래스가 가지는 것을 매개변수로 가지는 클래스를 생성하겠다.
public class BookServiceImpl implements BookService{
    private BookMapper bookMapper;
    
	@Autowired
	BookServiceImpl(BookMapper bookMapper){
		this.bookMapper = bookMapper;
	}

	@Override
	public List<BookVO> bookList() {
		return bookMapper.selectBookAll();
	}

	@Override
	public int insertBook(BookVO bookVO) {
		return bookMapper.insertBookInfo(bookVO);
	}

	@Override
	public List<BookVO> bookall() {
		return bookMapper.Bookall();
	}

};
