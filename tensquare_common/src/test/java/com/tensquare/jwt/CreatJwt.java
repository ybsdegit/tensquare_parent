package com.tensquare.jwt;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * CreatJwt
 *
 * @author Paulson
 * @date 2020/1/4 1:39
 */
public class CreatJwt {
    public static void main(String[] args) {
        JwtBuilder jwtBuilder = Jwts.builder()
                .setId("666")
                .setSubject("小马")
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, "paulson")
                .setExpiration(new Date(new Date().getTime() + 60000))
                .claim("role", "admin");

        System.out.println(jwtBuilder.compact());
    }

}
