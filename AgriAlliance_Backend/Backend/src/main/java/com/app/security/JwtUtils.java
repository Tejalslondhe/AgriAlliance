package com.app.security;

import java.security.Key;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.app.entities.Doctor;
import com.app.entities.Farmer;
import com.app.entities.Merchant;
import com.app.entities.Worker;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class JwtUtils {

    @Value("${EXP_TIMEOUT}")
    private int jwtExpirationMs;

    private Key key;

    @PostConstruct
    public void init() {
        // Generate a secure key for HS512
        key = Keys.secretKeyFor(SignatureAlgorithm.HS512);
    }

    // Generate JWT token for the authenticated user
   /* public String generateJwtToken(Authentication authentication) {
        log.info("Generating JWT token for authentication: " + authentication);

        CustomUserDetails userPrincipal = (CustomUserDetails) authentication.getPrincipal();
        String username = userPrincipal.getUsername();
        String role = userPrincipal.getUser().getRole().name();
        Long userId = getUserIdFromUserRole(userPrincipal);

        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
                .claim("authorities", getAuthoritiesInString(userPrincipal.getAuthorities()))
                .claim("user_id", userId)
                .claim("role", role)
                .signWith(key, SignatureAlgorithm.HS512)
                .compact();
    }*/
    
    public String generateJwtToken(Authentication authentication) {
        CustomUserDetails userPrincipal = (CustomUserDetails) authentication.getPrincipal();
        return Jwts.builder()
            .setSubject(userPrincipal.getUsername())
            .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime() + jwtExpirationMs))
            .claim("authorities", getAuthoritiesInString(userPrincipal.getAuthorities()))
            .claim("user_id", userPrincipal.getUserId()) // Use appropriate method
            .signWith(key, SignatureAlgorithm.HS512)
            .compact();
    }


    // Extract username from JWT token
    public String getUserNameFromJwtToken(Claims claims) {
        return claims.getSubject();
    }

    // Validate JWT token and return claims
    public Claims validateJwtToken(String jwtToken) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(jwtToken)
                    .getBody();
        } catch (Exception e) {
            log.error("JWT token validation failed", e);
            throw e;
        }
    }

    // Convert GrantedAuthority collection to comma-separated string
    private String getAuthoritiesInString(Collection<? extends GrantedAuthority> authorities) {
        return authorities.stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));
    }

    // Extract authorities from claims
    public List<GrantedAuthority> getAuthoritiesFromClaims(Claims claims) {
        String authString = (String) claims.get("authorities");
        return AuthorityUtils.commaSeparatedStringToAuthorityList(authString);
    }

    // Extract user ID based on the role from claims
    public Long getUserIdFromJwtToken(Claims claims) {
        return Long.valueOf((int) claims.get("user_id"));
    }

    // Determine the user ID based on the user's role
    private Long getUserIdFromUserRole(CustomUserDetails userPrincipal) {
        switch (userPrincipal.getUser().getRole()) {
            case FARMER:
                return ((Farmer) userPrincipal.getUser()).getFarmerId();
            case MERCHANT:
                return ((Merchant) userPrincipal.getUser()).getMerchantId();
            case WORKER:
                return ((Worker) userPrincipal.getUser()).getWorkerId();
            case DOCTOR:
                return ((Doctor) userPrincipal.getUser()).getDoctorId();
            default:
                throw new IllegalArgumentException("Unexpected role: " + userPrincipal.getUser().getRole());
        }
    }

    // Populate Authentication token from JWT
    public Authentication populateAuthenticationTokenFromJWT(String jwt) {
        Claims claims = validateJwtToken(jwt);
        String username = getUserNameFromJwtToken(claims);
        List<GrantedAuthority> authorities = getAuthoritiesFromClaims(claims);
        Long userId = getUserIdFromJwtToken(claims);

        return new UsernamePasswordAuthenticationToken(username, userId, authorities);
    }
}
