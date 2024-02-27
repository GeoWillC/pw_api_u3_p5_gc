package com.example.demo.security;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;


@Component
public class JwtUtils {
    private static final org.slf4j.Logger LOG = LoggerFactory.getLogger(JwtUtils.class);

    public boolean validateJwt(String authToken) {
        try {
            Jwts.parser().setSigningKey(
                    "cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e")
                    .parseClaimsJws(authToken);
            return true;
        } catch (Exception e) {
            // TODO: handle exception
            LOG.error("ERRRRRRRRRRORRRR	", e);
        }
        return false;
    }

    public String getUserNameFromjwtToken(String token) {
        return Jwts.parser().setSigningKey(
                "cf83e1357eefb8bdf1542850d66d8007d620e4050b5715dc83f4a921d36ce9ce47d0d13c5d85f2b0ff8318d2877eec2f63b931bd47417a81a538327af927da3e")
                .parseClaimsJws(token).getBody().getSubject();
    }
}
