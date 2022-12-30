package com.ssafy.whereismyhome.model.mapper;

import com.ssafy.whereismyhome.model.dto.CommentDTO;
import com.ssafy.whereismyhome.model.dto.CommentParameterDto;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.ArrayList;
@Mapper
public interface CommentMapper {
    ArrayList<CommentDTO> list(CommentParameterDto commentParameterDto) throws SQLException;
    int getTotalCount(CommentParameterDto commentParameterDto) throws SQLException;

    int write(CommentDTO commentDTO) throws SQLException;

    int update(CommentDTO commentDTO) throws SQLException;

    int delete(int comment_id) throws SQLException;
}
