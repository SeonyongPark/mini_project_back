package com.ssafy.whereismyhome.jwt;

import java.time.Duration;
import java.util.Base64;
import java.util.Date;

import javax.annotation.PostConstruct;
import javax.xml.bind.DatatypeConverter;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtProvider {
	private String secretKey = "SsafyTimeSecretKey12345";
	private static JwtProvider instacne  = new JwtProvider();

	public static JwtProvider getInstance() {
		return instacne;
	}
	
    private long tokenValidTime = Duration.ofMinutes(30).toMillis();

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }
    

    public String createToken(String userId, String userNickname) {
        Claims claims = Jwts.claims();
        claims.put("userId", userId);
        claims.put("nickname", userNickname);
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims) 
                .setIssuedAt(now) 
                .setExpiration(new Date(now.getTime() + tokenValidTime)) 
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    public String createExpireToken() {
        Claims claims = Jwts.claims();

        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + 0))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    

    public String getUserInfo(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("userId").toString();
    }

    public boolean validateToken(String jwtToken) {

        try {

        	Claims claims = Jwts.parser()
        			.setSigningKey(DatatypeConverter.parseBase64Binary(secretKey))
        			.parseClaimsJws(jwtToken)
        			.getBody();
        	return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
        	e.printStackTrace();
            return false;
        }
    }

}
