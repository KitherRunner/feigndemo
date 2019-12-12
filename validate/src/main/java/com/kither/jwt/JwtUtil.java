package com.kither.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Date;
import java.util.UUID;

public class JwtUtil {

    public static String generateToken() {
        long ttlMill = System.currentTimeMillis();
        return Jwts.builder().setIssuer(JwtConstants.ISSUER)
                .setSubject(JwtConstants.SUBJECT)
                .setIssuedAt(new Date(ttlMill))
                .setId(UUID.randomUUID().toString())
                .setExpiration(new Date(ttlMill + JwtConstants.TTL))
                .signWith(SignatureAlgorithm.HS256, key()).compact();
    }

    public static Claims parseToken(String jwtToken) {
        return Jwts.parser().setSigningKey(key())
                .parseClaimsJws(jwtToken).getBody();
    }

    private static SecretKey key() {
        byte[] secret = Base64Codec.BASE64.decode(JwtConstants.SECRET);
        return new SecretKeySpec(secret, 0, secret.length, "AES");
    }
}
