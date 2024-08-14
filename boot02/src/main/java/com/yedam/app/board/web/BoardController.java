package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;


@Controller
public class BoardController {
  
    private BoardService boardService;
	
    @Autowired
    public BoardController(BoardService boardService) {
    	this.boardService= boardService;
    }
	// 전체조회 : URI - boardList / RETURN - board/boardList    
    @GetMapping("boardList")
    public String boardList(Model model) {
    	List<BoardVO> list = boardService.boardList();
    	model.addAttribute("boards", list);
    	
    	return "board/boardList";
    }
	// 단건조회 : URI - boardInfo / PARAMETER - BoardVO(QueryString)
	//          RETURN - board/boardInfo
    @GetMapping("boardInfo")
    public String boardInfo(BoardVO boardVO, Model model) {
    	BoardVO findVO = boardService.boardInfo(boardVO);
    	model.addAttribute("board", findVO);
    	
    	return "board/boardInfo";
    }
	
	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
    @GetMapping("boardInsert")
    public String boardInsertFrom() {
    	return "board/boardInsert";
    }
	
	// 등록 - 처리 : URI - boardInsert / PARAMETER - BoardVO(QueryString)
	//             RETURN - 단건조회 다시 호출
    @PostMapping("boardInsert")
    public String boardInsertProcess(BoardVO boardVO) {
    	int id = boardService.insertBoard(boardVO);
    	    return "redirect:boardInfo?bno="+id;
    	}
    	
    
	
	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO(QueryString)
	//               RETURN - board/boardUpdate
    // 결국에 수정은 단건조회 페이지임.
    @GetMapping("boardUpdate")
    public String boardUpdateFrom(BoardVO boardVO, Model model) {
    	BoardVO findVO = boardService.boardInfo(boardVO);
    	model.addAttribute("board",findVO);
    	return "board/boardUpdate";
    }
     
	
	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO(JSON)
	//             RETURN - 수정결과 데이터(Map)
    //얘는 사실상 등록과 같음.(내부에서 수행하는 쿼리문 - update문)
    @PostMapping("boardUpdate")//일반적으로 <form/> 활용 => QueryString방식 사용
    @ResponseBody //=>Ajax
    public String boardUpdateProcess(@RequestBody BoardVO boardVO){
    	return "boardService.updateBoard(boardVO)";//페이지나 url를 리턴하는게 아니면 (데이터가 리턴된다는건)아작스를 쓰겠다.
    }
	
	// 삭제 - 처리 : URI - boardDelete / PARAMETER - Integer
	//             RETURN - 전체조회 다시 호출
    @GetMapping("boardDelete")
    public String boardDelete(@RequestParam Integer no) {
    	boardService.deleteBoard(no);
    	return "redirect:empList";
    }
}
