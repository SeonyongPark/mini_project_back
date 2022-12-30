package com.ssafy.whereismyhome.model.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.whereismyhome.model.mapper.MemberMapper;
import com.ssafy.whereismyhome.model.dto.MemberDTO;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberMapper memberMapper;

	@Override
	public void regist(MemberDTO dto) throws Exception {
		memberMapper.regist(dto);
	}

	@Override
	public MemberDTO login(Map<String, String> map) throws Exception {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO = memberMapper.login(map);
		return memberDTO;
	}

	@Override
	public void update(MemberDTO dto) throws Exception {
		memberMapper.update(dto);
	}

	@Override
	public void delete(String userId) throws Exception {
		memberMapper.delete(userId);
	}

	@Override
	public MemberDTO view(String userId) throws Exception {
		return memberMapper.view(userId);
	}

}
