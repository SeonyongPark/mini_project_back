package com.ssafy.whereismyhome.model.service;

import com.ssafy.whereismyhome.model.dto.BookmarkDTO;
import com.ssafy.whereismyhome.model.dto.HouseinfoDTO;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface BookmarkService {
    List<HouseinfoDTO> list(String userId) throws Exception;
    boolean delete(String code) throws Exception;
    boolean like(BookmarkDTO dto) throws Exception;
    boolean comfirm(Map map)throws Exception;
}
