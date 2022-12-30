package com.ssafy.whereismyhome.model.mapper;

import java.sql.SQLException;
import java.util.Map;

import com.ssafy.whereismyhome.model.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface MemberMapper {
	void regist(MemberDTO memberDTO) throws SQLException;
	MemberDTO login(Map<String, String> map) throws SQLException;
	void update(MemberDTO dto) throws SQLException;
	MemberDTO view(String userId) throws SQLException;
	void delete(String userId) throws SQLException;
}
