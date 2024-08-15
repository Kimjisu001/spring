package com.yedam.app.book.web;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;


@Controller
public class BookController {
	
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService= bookService;
	}
	
	//도서목록 조회
	@GetMapping("/bookList")
	public String bookList(Model model, BookVO bookVO) {
		model.addAttribute("list", bookService.bookList());
		return "book/bookList";
	}

	//도서 등록:페이지
	@GetMapping("/insertBook")
	public String insertBook() {
		return "book/insertBook";
	}
	
	//도서 등록:처리
	@PostMapping("/insertBook")
	public String bookInsert(BookVO bookVO) {
		int bno = bookService.insertBook(bookVO);
		String url=null;
		if(bno > -1) {
			url="redirect:insertBook?bno="+bno;
		}else {
			url="redirect:empList";
		}	
		  return url;
	}

	//도서대여현황
	@GetMapping("/bookall")
	public String bookall(Model model, BookVO bookVO) {
		model.addAttribute("list", bookService.bookall());
		return "book/bookall";
	}


}
