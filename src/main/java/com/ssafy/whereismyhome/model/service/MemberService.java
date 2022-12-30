package com.ssafy.whereismyhome.model.service;

import java.util.Map;

import com.ssafy.whereismyhome.model.dto.MemberDTO;

public interface MemberService {
	void regist(MemberDTO dto) throws Exception;
	MemberDTO login(Map<String, String> map) throws Exception;
	void update(MemberDTO dto) throws Exception;
	MemberDTO view(String userId) throws Exception;
	void delete(String userId) throws Exception;
}
