package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
    //전체조회 : 조건- bno
	public List<BoardVO> selectBoardAll();
	
	//단건조회 : 조건-bno, title, contents, writer, regdate, image
	public BoardVO selectBoardInfo(BoardVO boardVO);
	
	//등록
	public int insertBoardInfo(BoardVO boardVO);
	
	//수정
	public int updateBoardInfo(BoardVO boardVO);

	//삭제	
	public int deleteBoardInfo(int boardNO);
}
