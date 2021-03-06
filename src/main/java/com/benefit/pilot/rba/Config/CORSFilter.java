package com.benefit.pilot.rba.Config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class CORSFilter implements WebMvcConfigurer {

 @Override
 public void addCorsMappings(CorsRegistry registry) {
	 System.out.println("cors filter.................");
  registry.addMapping("/**")
                .allowCredentials(true)
                .allowedOrigins("http://localhost:4200");

 }
} 

/*@CrossOrigin
@Configuration
public class CORSFilter implements Filter {

 public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
  System.out.println("Filtering on...........................................................");
  HttpServletResponse response = (HttpServletResponse) res;
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Credentials", "true");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
       response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, Content-Type, Authorization, Origin, Accept, Access-Control-Request-Method, Access-Control-Request-Headers");
 }}*/
  
 /* HttpServletRequest request = (HttpServletRequest) req;
  HttpServletResponse response = (HttpServletResponse) res;

  response.addHeader("Access-Control-Allow-Origin", "*");

  if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
      response.setHeader("Access-Control-Allow-Methods", "POST,GET,DELETE");
      response.setHeader("Access-Control-Max-Age", "3600");
      response.setHeader("Access-Control-Allow-Headers", "content-type,access-control-request-headers,access-control-request-method,accept,origin,authorization,x-requested-with");
      response.setStatus(HttpServletResponse.SC_OK);
  } else {
      chain.doFilter(req, res);
  }*/
    
  
