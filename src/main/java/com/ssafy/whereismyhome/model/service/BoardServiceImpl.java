package com.ssafy.whereismyhome.model.service;


import java.util.ArrayList;

import com.ssafy.whereismyhome.model.dto.BoardParameterDTO;
import com.ssafy.whereismyhome.util.PageNavigation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssafy.whereismyhome.model.mapper.BoardMapper;
import com.ssafy.whereismyhome.model.dto.BoardDTO;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Configurable
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	private BoardMapper boardMapper;

	@Autowired
	private SqlSession sqlSession;

	@Override
	public ArrayList<BoardDTO> list(BoardParameterDTO boardParameterDto) throws Exception {
		int start = boardParameterDto.getPg() == 0 ? 0 : (boardParameterDto.getPg() - 1) * boardParameterDto.getSpp();
		boardParameterDto.setStart(start);

		return boardMapper.list(boardParameterDto);
	}
	@Override
	public boolean write(BoardDTO boardDto) throws Exception {
		if(boardDto.getSubject() == null || boardDto.getContent() == null) {
			throw new Exception();
		}
		return sqlSession.getMapper(BoardMapper.class).write(boardDto) == 1;
	}
	@Override
	public BoardDTO view(int boardNo) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).view(boardNo);

	}
	@Override
	public boolean update(BoardDTO boardDto) throws Exception {
		return sqlSession.getMapper(BoardMapper.class).update(boardDto) == 1;
	}
	@Override
	@Transactional
	public boolean delete(int boardno) throws Exception {
		return boardMapper.delete(boardno) == 1;
	}
	@Override
	public PageNavigation makePageNavigation(BoardParameterDTO boardParameterDto) throws Exception {
		int naviSize = 10;
		PageNavigation pageNavigation = new PageNavigation();
		pageNavigation.setCurrentPage(boardParameterDto.getPg());
		pageNavigation.setNaviSize(naviSize);
		int totalCount = sqlSession.getMapper(BoardMapper.class).getTotalCount(boardParameterDto);//총글갯수  269
		pageNavigation.setTotalCount(totalCount);
		int totalPageCount = (totalCount - 1) / boardParameterDto.getSpp() + 1;//27
		pageNavigation.setTotalPageCount(totalPageCount);
		boolean startRange = boardParameterDto.getPg() <= naviSize;
		pageNavigation.setStartRange(startRange);
		boolean endRange = (totalPageCount - 1) / naviSize * naviSize < boardParameterDto.getPg();
		pageNavigation.setEndRange(endRange);
		pageNavigation.makeNavigator();
		return pageNavigation;
	}

}
