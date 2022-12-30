package com.ssafy.whereismyhome.model.mapper;

import com.ssafy.whereismyhome.model.dto.BoardDTO;
import com.ssafy.whereismyhome.model.dto.BookmarkDTO;
import com.ssafy.whereismyhome.model.dto.HouseinfoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@Mapper
public interface BookmarkMapper {
    List<HouseinfoDTO> list(String userId) throws SQLException;
    int delete(String code) throws SQLException;
    int like(BookmarkDTO dto) throws SQLException;
    BookmarkDTO comfirm(Map map)throws SQLException;
}
