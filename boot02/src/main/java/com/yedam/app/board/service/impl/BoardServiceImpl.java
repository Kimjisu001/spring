package com.yedam.app.board.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

import javassist.Loader.Simple;

@Service
public class BoardServiceImpl implements BoardService{

	   private BoardMapper boardMapper;
	   
	   @Autowired
	   BoardServiceImpl(BoardMapper boardMapper){
		   this.boardMapper = boardMapper;
	   }
	   
	   @Override
	   public int insertBoard(BoardVO boardVO) {
		   int result = boardMapper.insertBoardInfo(boardVO);
		   return result == 1? boardVO.getBno() : -1;
	   }
	   //맵을 활용한 이유=>아작스를 사용할거여서 이 형태의 맵은 임시 클래스라고 보면됨.
	   @Override
	   public Map<String,Object> updateBoard (BoardVO boardVO){
		   Map<String,Object>map =new HashMap<>();
		   boolean isSuccessed = false;
		   
		   int result = boardMapper.updateBoardInfo(boardVO);
		   if(result ==1) {
                  isSuccessed = true;
		   }
		   
		   Date today = new Date();
		   SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		   String updateDate = sdf.format(today);
		   
		   map.put("date", updateDate);
		   map.put("result", updateDate);
		   map.put("target", updateDate);
		   
		   return map;
	   }
	   
	   @Override
	   public int deleteBoard(int boardNO) {
		   return boardMapper.deleteBoardInfo(boardNO);
	   }

	@Override
	public List<BoardVO> boardList() {
		return boardMapper.selectBoardAll();
	}

	@Override
	public BoardVO boardInfo(BoardVO boardVO) {
		return boardMapper.selectBoardInfo(boardVO);
	}
	
//	@Override
//	public int insertBoard(BoardVO boardVO) {
//		int result = boardMapper.insertBoardInfo(boardVO);
//		return null;
//	}
}
