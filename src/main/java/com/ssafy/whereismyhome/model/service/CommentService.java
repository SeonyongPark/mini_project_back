package com.ssafy.whereismyhome.model.service;

import com.ssafy.whereismyhome.model.dto.CommentDTO;
import com.ssafy.whereismyhome.model.dto.CommentParameterDto;
import com.ssafy.whereismyhome.util.PageNavigation;

import java.util.ArrayList;

public interface CommentService {
    ArrayList<CommentDTO> list(CommentParameterDto commentParameterDto) throws Exception;

    public PageNavigation makePageNavigation(CommentParameterDto commentParameterDto) throws Exception;

    boolean write(CommentDTO commentDTO) throws Exception;

    boolean update(CommentDTO commentDTO) throws Exception;

    boolean delete(int comment_id) throws Exception;
}
