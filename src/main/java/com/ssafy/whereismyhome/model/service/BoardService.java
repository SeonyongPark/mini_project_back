package com.ssafy.whereismyhome.model.service;


import java.util.ArrayList;

import com.ssafy.whereismyhome.model.dto.BoardDTO;
import com.ssafy.whereismyhome.model.dto.BoardParameterDTO;
import com.ssafy.whereismyhome.util.PageNavigation;


public interface BoardService {
	ArrayList<BoardDTO> list(BoardParameterDTO boardParameterDto) throws Exception;
	public PageNavigation makePageNavigation(BoardParameterDTO boardParameterDto) throws Exception;

	boolean write(BoardDTO boardDto) throws Exception;

	BoardDTO view(int boardNo) throws Exception;

	boolean update(BoardDTO boardDto) throws Exception;

	public boolean delete(int boardno) throws Exception;
}
