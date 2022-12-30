package com.ssafy.whereismyhome.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.whereismyhome.model.dto.MemberDTO;
import com.ssafy.whereismyhome.jwt.JwtProvider;
import com.ssafy.whereismyhome.model.service.ApartService;
import com.ssafy.whereismyhome.model.service.MemberService;

/**
 * Servlet implementation class MemberServlet
 */
@RestController
@RequestMapping("/members")
@CrossOrigin
public class MemberController {

	@Autowired
	private MemberService memberService;
	@Autowired
	private ApartService apartService;

	@Autowired
	private JwtProvider jwtProvider;
	
	
	@PostMapping("/login")
	public ResponseEntity<?> login(@RequestBody Map<String, String> map) {
		Map<String , String> check = new HashMap<String, String>();
		try {
			MemberDTO memberDTO = memberService.login(map);
			if (memberDTO != null) {

				String key = jwtProvider.createToken(memberDTO.getUserId(), memberDTO.getUserPassword());
				check.put("access-token", key);
				check.put("msg", "success");

				return new ResponseEntity<Map<String , String>>(check, HttpStatus.OK);
			} else {
				check.put("msg", "로그인 실패!");
				return new ResponseEntity<Map<String , String>>(check, HttpStatus.NO_CONTENT);
			}
		} catch (Exception e) {
			e.printStackTrace();	
			check.put("msg", "로그인 도중 오류 발생!");
			return new ResponseEntity<Map<String , String>>(check, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping
	public ResponseEntity<?> regist(@RequestBody MemberDTO memberDTO) {
		Map<String , String> check = new HashMap<String, String>();
		
		try {
			check.put("msg", "success");

			memberService.regist(memberDTO);
			
			return new ResponseEntity<Map<String , String>>(check, HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			check.put("msg", "fail");
			return new ResponseEntity<>(check, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@DeleteMapping("{userId}")
	public ResponseEntity<?> delete(@PathVariable String userId) {
		Map<String , String> check = new HashMap<String, String>();
		
		try {
			memberService.delete(userId);

			check.put("msg", "success");
			return new ResponseEntity<>(check, HttpStatus.OK);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			check.put("msg", "회원정보 탈퇴 중 오류가 발생하였습니다.");
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}


	@PutMapping("{userId}")
	public ResponseEntity<?> update(@RequestBody MemberDTO memberDTO) {
		Map<String , String> check = new HashMap<String, String>();
		
		try {
			memberService.update(memberDTO);
			check.put("msg", "success");

			return new ResponseEntity<Map<String , String>>(check, HttpStatus.OK);
		} catch (Exception e) {
			check.put("msg", "회원정보 수정 중 오류가 발생하였습니다.");
			return new ResponseEntity<Map<String , String>>(check, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("{userId}")
	public ResponseEntity<?> getUser(@PathVariable String userId) {
		Map<String , Object > check = new HashMap<>();

		try {
			MemberDTO memberDTO = memberService.view(userId);
			check.put("msg", "success");
			check.put("userInfo", memberDTO);

			return new ResponseEntity<Map<String , Object >>(check, HttpStatus.ACCEPTED);
		} catch (Exception e) {
			e.printStackTrace();
			check.put("msg", "로그인 중 에러 발생!");
			return new ResponseEntity<>(check,HttpStatus.OK);
		}
	}

	@GetMapping("check/{userId}")
	public ResponseEntity<?> checkId(@PathVariable String userId) {
		Map<String , String > check = new HashMap<>();

		try {
			MemberDTO memberDTO = memberService.view(userId);

			if(memberDTO == null){
				check.put("msg", "success");
				return new ResponseEntity<Map<String , String >>(check,HttpStatus.OK);
			}
			check.put("msg", "fail");
			return new ResponseEntity<MemberDTO>(memberDTO,HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			e.printStackTrace();
			check.put("msg", "fail");
			return new ResponseEntity<>(check,HttpStatus.OK);
		}
	}
}
