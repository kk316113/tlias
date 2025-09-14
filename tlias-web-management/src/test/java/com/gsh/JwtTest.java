package com.gsh;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtTest {
    @Test
    public void jwtTest() {
        Map<String, Object> dataMap = new HashMap<>();
        dataMap.put("id", 1);
        dataMap.put("username", "admin");
        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "Z3No")//指定加密算法和密钥
                .addClaims(dataMap)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 3600 * 1000))//设置过期时间
                .compact();// compact()方法生成令牌
        System.out.println(jwt);
    }
    @Test
    public void parseJwt() {
        String token="eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MSwidXNlcm5hbWUiOiJhZG1pbiIsImV4cCI6MTc1NzU3NTE2OH0.wblvxygVPEDkSryReVpBZX9l_Fjl6HT4TOdawjlGC-c";
        Claims claims = Jwts.parser()
                .setSigningKey("Z3No")
                .parseClaimsJws(token)
                .getBody();
        System.out.println(claims);
    }
}
