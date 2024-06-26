package com.yasar.config;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Objects;
import java.util.Optional;

@Service
public class JwtManager {

    private final String SECRETKEY = "-vE6.70erqB)lrO+S-mJs&0_vapJHrG4=!RHuM1RMgdTjNpQ}G";
    private final Long EXDATE = 1000L * 30;

    /**
     * Create Token
     * Access Token
     * Get Parameter
     */

    public String createToken(Long authId) {
        Algorithm algorithm = Algorithm.HMAC512(SECRETKEY);
        String token = JWT.create()
                .withAudience()
                .withExpiresAt(new Date(System.currentTimeMillis() + EXDATE))
                .withIssuer("BILGE")
                .withIssuedAt(new Date(System.currentTimeMillis()))
                .withClaim("serviceName", "AUTH")
                .withClaim("authId", authId)
                .withClaim("hangiGun", "Persembe")
                .sign(algorithm);
        return token;
    }

    public Optional<Long> getAuthId(String token) {
        try {
            Algorithm algorithm = Algorithm.HMAC512(SECRETKEY);
            JWTVerifier jwtVerifier = JWT.require(algorithm).build();
            DecodedJWT decodedJWT = jwtVerifier.verify(token);
            if (Objects.isNull(decodedJWT))
                return Optional.empty();
            Long authId = decodedJWT.getClaim("authId").asLong();
            return Optional.of(authId);
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
