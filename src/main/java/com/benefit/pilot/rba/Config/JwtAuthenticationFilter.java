package com.benefit.pilot.rba.Config;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static com.benefit.pilot.rba.Auth.Models.Constants.HEADER_STRING;
import static com.benefit.pilot.rba.Auth.Models.Constants.TOKEN_PREFIX;

import java.io.IOException;


public class  JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String header = req.getHeader(HEADER_STRING);
        
        String authToken = null;
        Boolean usingCookie = false;
        Boolean goodAuth = false;
        logger.info("Requested URL: " + req.getRequestURL());
        if (header != null && header.startsWith(TOKEN_PREFIX)) {
            authToken = header.replace(TOKEN_PREFIX,"");
        } else {
            logger.info("No auth header. Checking cookies for token");
            Cookie[] cookies = req.getCookies();
            if(cookies != null) {
                for(Cookie cookie: cookies) {
                    if(cookie.getName().equalsIgnoreCase(HEADER_STRING)) {
                        authToken = cookie.getValue().replace("Bearer+","");
                        logger.info("Found token in cookie.");
                        usingCookie = true;
                    }
                }
            }

        }

        if(authToken != null) {
            try {
                if(jwtTokenUtil.validateTokenSignature(authToken)) {
                    //good token
                    if(!jwtTokenUtil.isTokenExpired(authToken)) {
                        Claims claims = jwtTokenUtil.getAllClaimsFromToken(authToken);
                        //set principal to userid
                        UsernamePasswordAuthenticationToken authentication;
                        authentication = new UsernamePasswordAuthenticationToken(claims.get("id", Integer.class),
                                null, null);

                        authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                        authentication.setDetails(authToken);
                        SecurityContextHolder.getContext().setAuthentication(authentication);
                        goodAuth = true;
                        System.out.println("authentication==="+authentication);

                    }
                }
            } catch (MalformedJwtException e) {
                logger.error("Header does not reference a valid signature alg.");
            }
            catch (IllegalArgumentException e) {
                logger.error("an error occurred during getting username from token", e);
            } catch (ExpiredJwtException e) {
                logger.warn("the token is expired and not valid anymore", e);
            } catch(SignatureException e){
                logger.error("Authentication Failed. Username or Password not valid.");
            } catch (Exception e) {
                logger.warn("goodAuth = false;");
                goodAuth = false;
            }
        } else {
            goodAuth = false;

        }
        if(!goodAuth && usingCookie) {
            logger.error("Got a bad auth cookie, logging the user out.");
            res = handleBadAuthCookie(res);
            res.setStatus(401);
        }
        if(!goodAuth && !usingCookie) {
            logger.warn("Unauthorized, no cookie, sending home.");
            res.setStatus(401);
        }
        logger.info("Path Info:" + req.getRequestURI());
        if(req.getRequestURI().equalsIgnoreCase("/") ||
                req.getRequestURL().toString().contains("ngsw.json") ||
                req.getRequestURL().toString().endsWith("/public/images/biglogo.jpg") || 
                req.getRequestURL().toString().endsWith("/public/css/bootstrap.min.css") || 
                req.getRequestURL().toString().endsWith("/public/js/jquery-3.2.1.min.js") || 
                req.getRequestURL().toString().endsWith("/public/js/bootstrap.min.js") ||
                req.getRequestURL().toString().endsWith("/public/css/layout.css") ||
                req.getRequestURL().toString().endsWith("/public/js/popper.min.js"))
        {
            // white listed public resources as well as login/home page.
            res.setStatus(200);
        }
        chain.doFilter(req, res);
    }

    private HttpServletResponse handleBadAuthCookie(HttpServletResponse res) {
        Cookie unsetAuthCookie = new Cookie(HEADER_STRING, null);
        unsetAuthCookie.setPath("/");
        unsetAuthCookie.setHttpOnly(true);
        unsetAuthCookie.setMaxAge(0);
        res.addCookie(unsetAuthCookie);
        System.out.println("inside handleBadAuthCookie =");
        return res;
    }
}