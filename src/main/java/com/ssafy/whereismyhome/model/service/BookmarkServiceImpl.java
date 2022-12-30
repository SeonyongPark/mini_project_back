package com.ssafy.whereismyhome.model.service;

import com.ssafy.whereismyhome.model.dto.BookmarkDTO;
import com.ssafy.whereismyhome.model.dto.HouseinfoDTO;
import com.ssafy.whereismyhome.model.mapper.BoardMapper;
import com.ssafy.whereismyhome.model.mapper.BookmarkMapper;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookmarkServiceImpl implements BookmarkService{

    @Autowired
    BookmarkMapper bookmarkMapper;

    @Autowired
    private SqlSession sqlSession;

    @Override
    public List<HouseinfoDTO> list(String userId) throws Exception {
        return bookmarkMapper.list(userId);
    }

    @Override
    public boolean delete(String code) throws Exception {
        return sqlSession.getMapper(BookmarkMapper.class).delete(code) == 1;
    }

    @Override
    public boolean like(BookmarkDTO dto) throws Exception {
        return sqlSession.getMapper(BookmarkMapper.class).like(dto) == 1;
    }

    @Override
    public boolean comfirm(Map map) throws Exception {
        return sqlSession.getMapper(BookmarkMapper.class).comfirm(map) != null;
    }
}
