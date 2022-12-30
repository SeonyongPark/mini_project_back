package com.ssafy.whereismyhome.interceptor;


import com.ssafy.whereismyhome.jwt.JwtProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class JwtInterceptor implements HandlerInterceptor {

public static final Logger logger = LoggerFactory.getLogger(JwtInterceptor.class);
	
	private static final String HEADER_AUTH = "auth_token";

	private final JwtProvider jwtService;

	@Autowired
	public JwtInterceptor(JwtProvider jwtService) {

		this.jwtService = jwtService;
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {

		if(HttpMethod.GET.matches(request.getMethod())){
			return true;
		}

		if(HttpMethod.OPTIONS.matches(request.getMethod())){
			return true;
		}

		String token = request.getHeader(HEADER_AUTH);

		try {
			if(!jwtService.validateToken(token)){
				response.sendError(401, "UNAUTHORIZATION");
				return false;
			} else{
				return true;
			}
		}catch(Exception e){
			e.printStackTrace();
		}

		return false;

	}

}
