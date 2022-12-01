package com.bilibili.common.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;

public class TokenUtils {

    private static final String ISSUER="SYSTEM";

    public static String generateToken(String userId) throws Exception {
        Algorithm algorithm=Algorithm.RSA256(RSAUtils.getPublicKey(),RSAUtils.getPrivateKey());
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(new Date());
        calendar.add(Calendar.SECOND,30);
        return JWT.create().withKeyId(userId).withIssuer(ISSUER).withExpiresAt(calendar.getTime())
                .sign(algorithm);
    }


    public static String verifyToken(String token) throws Exception {
        Algorithm algorithm = Algorithm.RSA256(RSAUtils.getPublicKey(), RSAUtils.getPrivateKey());
        JWTVerifier jwtVerifier = JWT.require(algorithm).build();
        DecodedJWT jwt = jwtVerifier.verify(token);
        String userId = jwt.getKeyId();
        return userId;
    }
}
