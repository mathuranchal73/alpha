package com.alpha.security;

import static net.logstash.logback.argument.StructuredArguments.kv;

import java.util.Base64;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.alpha.security.JwtTokenProvider;
import com.alpha.web.RequestCorrelation;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

@Component
public class JwtTokenProvider {
	
private static final Logger logger = LoggerFactory.getLogger(JwtTokenProvider.class);

private static final String AUTH="auth";
private static final String AUTHORIZATION="Authorization";

private static final String REDIS_SET_ACTIVE_SUBJECTS = "active-subjects";
	
	@Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;
    
    
    @PostConstruct
    protected void init() {
        jwtSecret = Base64.getEncoder().encodeToString(jwtSecret.getBytes());
    }

    
    public Long getUserIdFromJWT(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtSecret)
                .parseClaimsJws(token)
                .getBody();
        logger.debug("Parsed User Details",kv("claims",claims), kv("correlationId", RequestCorrelation.CORRELATION_ID_HEADER));
        return Long.parseLong(claims.getSubject());
    }
    
    
    public boolean validateToken(String authToken) {
        try {
        	Claims claims =Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken).getBody();
        	

        } catch (SignatureException ex) {
            logger.error("Invalid JWT signature",kv("correlationId", RequestCorrelation.CORRELATION_ID_HEADER));
        } catch (MalformedJwtException ex) {
            logger.error("Invalid JWT token",kv("correlationId", RequestCorrelation.CORRELATION_ID_HEADER));
        } catch (ExpiredJwtException ex) {
            logger.error("Expired JWT token",kv("correlationId", RequestCorrelation.CORRELATION_ID_HEADER));
        } catch (UnsupportedJwtException ex) {
            logger.error("Unsupported JWT token",kv("correlationId", RequestCorrelation.CORRELATION_ID_HEADER));
        } catch (IllegalArgumentException ex) {
            logger.error("JWT claims string is empty.",kv("correlationId", RequestCorrelation.CORRELATION_ID_HEADER));
        }
        return false;
    }


	
    

}
