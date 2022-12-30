package com.ssafy.whereismyhome;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ssafy.whereismyhome.jwt.JwtProvider;

public class UserTest extends UnitTestConfig {
	String key = null;
	private final Logger logger = LoggerFactory.getLogger(UserTest.class);
	
	JwtProvider jp = JwtProvider.getInstance();


	@BeforeAll
	public static void beforeClass() {
		System.out.println("----- Class Test Start!!! -----");
	}
	
	@AfterAll
	public static void afterClass() {
		System.out.println("----- Class Test End!!! -----");
	}
	
	@BeforeEach
	public void beforeMethod() {
		System.out.println("----- Method Test Start!!! -----");
	}
	
	@AfterEach
	public void afterMethod() {
		System.out.println("----- Method Test End!!! -----");
	}
	
	@Test
	@BeforeEach
	// 단위테스트
	public void 토큰_생성() {
		key = jp.createToken("ssafy", "1234");
		assertNotNull(key);
	}
	
	@Test
	public void 토큰_확인() {
		assertTrue(jp.validateToken(key));
	}
	
	@Test
	public void 토큰_정보_추출() {
		String userId = jp.getUserInfo(key);
		assertEquals(userId, "ssafy");
	}
	

	
}