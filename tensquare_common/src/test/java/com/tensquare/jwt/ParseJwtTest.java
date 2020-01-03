package com.tensquare.jwt;

import io.jsonwebtoken.*;

import javax.sound.midi.Soundbank;
import java.text.SimpleDateFormat;

/**
 * ParseJwtTest
 *
 * @author Paulson
 * @date 2020/1/4 1:55
 */
public class ParseJwtTest {
    public static void main(String[] args) throws Exception {

        Claims claims = null;
        try {
            String token = "eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiI2NjYiLCJzdWIiOiLlsI_pqawiLCJpYXQiOjE1NzgwNzQ5MjQsImV4cCI6MTU3ODA3NDk4NCwicm9sZSI6ImFkbWluIn0.536cHwjh3wIapktj2V2CCepDveHB8YCQwA0h9L_7fyg";
            claims = Jwts.parser()
                    .setSigningKey("paulson")
                    .parseClaimsJws(token)
                    .getBody();
        } catch (ExpiredJwtException e) {
            throw new Exception("已过期");
        }
        System.out.println("用户id: " + claims.getId());
        System.out.println("用户名: " + claims.getSubject());
        System.out.println("登录时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getIssuedAt()));
        System.out.println("过期时间: " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(claims.getExpiration()));
        System.out.println("用户角色: " + claims.get("role"));
    }
}
