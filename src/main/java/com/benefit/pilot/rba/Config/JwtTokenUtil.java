package com.benefit.pilot.rba.Config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import com.benefit.pilot.rba.Auth.Models.User;
import static com.benefit.pilot.rba.Auth.Models.Constants.ACCESS_TOKEN_VALIDITY_SECONDS;
import static com.benefit.pilot.rba.Auth.Models.Constants.SIGNING_KEY;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

@Component
public class JwtTokenUtil implements Serializable {

    public String getUserIDFromToken(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    public Date getExpirationDateFromToken(String token) {
        return getClaimFromToken(token, Claims::getExpiration);
    }

    public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = getAllClaimsFromToken(token);
        return claimsResolver.apply(claims);
    }
    public boolean validateTokenSignature(String token) {
        return Jwts.parser().setSigningKey(SIGNING_KEY)
                .isSigned(token);
    }
    public Claims getAllClaimsFromToken(String token) {
        return Jwts.parser()
                .setSigningKey(SIGNING_KEY)
                .parseClaimsJws(token)
                .getBody();
    }

    public  Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    public String generateToken(User user) {
        return doGenerateToken(user);
    }
   
    private String doGenerateToken(User user) {

        Claims claims = Jwts.claims().setSubject(String.valueOf(user.getUsername()));
        claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority("ROLE_"+ user.getRole())));
        claims.put("id", user.getId());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS*1000))
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
    }
   
    public Boolean validateToken(String token, UserDetails userDetails) {
        final String username = getUserIDFromToken(token);
        return (
              username.equals(userDetails.getUsername())
                    && !isTokenExpired(token));
    }
}
