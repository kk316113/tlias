package com.gsh.utils;

import io.jsonwebtoken.*;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    // 密钥（建议放配置文件）
    private static final String SECRET_KEY = "Z3No";

    // 过期时间（12 小时）
    private static final long EXPIRATION_TIME = 12 * 60 * 60 * 1000L;

    /**
     * 生成 JWT 令牌
     * @param claims 自定义信息（键值对）
     * @return 生成的 token
     */
    public static String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims) // 设置自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 设置过期时间
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // 指定签名算法和密钥
                .compact();
    }

    /**
     * 解析 JWT 令牌
     * @param token 待解析的 token
     * @return Claims（包含自定义数据）
     * @throws ExpiredJwtException token 已过期
     * @throws JwtException token 无效
     */
    public static Claims parseToken(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody();
    }
}
