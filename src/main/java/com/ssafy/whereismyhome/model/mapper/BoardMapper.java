package com.ssafy.whereismyhome.model.mapper;

import java.sql.SQLException;
import java.util.ArrayList;

import com.ssafy.whereismyhome.model.dto.BoardParameterDTO;
import com.ssafy.whereismyhome.model.dto.BoardDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
	ArrayList<BoardDTO> list(BoardParameterDTO boardParameterDto) throws SQLException;
	int getTotalCount(BoardParameterDTO boardParameterDto) throws SQLException;

	int write(BoardDTO dto) throws SQLException;

	BoardDTO view(int articleNo) throws SQLException;

	int update(BoardDTO dto) throws SQLException;

	int delete(int boardno) throws SQLException;
}
