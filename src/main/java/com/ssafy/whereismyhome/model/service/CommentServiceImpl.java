package com.ssafy.whereismyhome.model.service;

import com.ssafy.whereismyhome.model.mapper.CommentMapper;
import com.ssafy.whereismyhome.model.dto.CommentDTO;
import com.ssafy.whereismyhome.model.dto.CommentParameterDto;
import com.ssafy.whereismyhome.util.PageNavigation;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Autowired
    private SqlSession sqlSession;

    @Override
    public ArrayList<CommentDTO> list(CommentParameterDto commentParameterDto) throws Exception {
        int start = commentParameterDto.getPg() == 0 ? 0 : (commentParameterDto.getPg() - 1) * commentParameterDto.getSpp();
        commentParameterDto.setStart(start);

        return commentMapper.list(commentParameterDto);
    }

    @Override
    public PageNavigation makePageNavigation(CommentParameterDto commentParameterDto) throws Exception {
        int naviSize = 10;
        PageNavigation pageNavigation = new PageNavigation();
        pageNavigation.setCurrentPage(commentParameterDto.getPg());
        pageNavigation.setNaviSize(naviSize);
        int totalCount = sqlSession.getMapper(CommentMapper.class).getTotalCount(commentParameterDto);
        pageNavigation.setTotalCount(totalCount);
        int totalPageCount = (totalCount - 1) / commentParameterDto.getSpp() + 1;
        pageNavigation.setTotalPageCount(totalPageCount);
        boolean startRange = commentParameterDto.getPg() <= naviSize;
        pageNavigation.setStartRange(startRange);
        boolean endRange = (totalPageCount -1) / naviSize * naviSize < commentParameterDto.getPg();
        pageNavigation.setEndRange(endRange);
        pageNavigation.makeNavigator();

        return pageNavigation;
    }

    @Override
    public boolean write(CommentDTO commentDTO) throws Exception {
        if(commentDTO.getContent() == null){
            throw  new Exception();
        }

        return sqlSession.getMapper(CommentMapper.class).write(commentDTO) == 1;
    }

    @Override
    public boolean update(CommentDTO commentDTO) throws Exception {
        return sqlSession.getMapper(CommentMapper.class).update(commentDTO) == 1;
    }

    @Override
    public boolean delete(int comment_id) throws Exception {
        return sqlSession.getMapper(CommentMapper.class).delete(comment_id) == 1;
    }
}
