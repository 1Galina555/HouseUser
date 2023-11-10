package com.example.houseuser.JWT;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import java.util.Date;


@Component
public class JWTToken {
    private static final String SUB = "galina_7";
    private static final String ISSUER = "galina";

    @Value("${jwt.secret}")
    private String jwtSecret;

    public String generate(String id) {
        return JWT.create()
                .withSubject(SUB)
                .withClaim("id", id)
                .withIssuedAt(new Date())
                .withIssuer(ISSUER)
                .sign(Algorithm.HMAC256(jwtSecret));
    }

    public String validateToken(String token) {
        return JWT.require(Algorithm.HMAC256(jwtSecret))
                .withSubject(SUB)
                .withIssuer(ISSUER)
                .build()
                .verify(token)
                .getClaim("id")
                .asString();
    }
}
