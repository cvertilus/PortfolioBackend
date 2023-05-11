package com.Portfolio.Porfolio_Backend.Security.JsonWebToken;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class JWTEntryPoint implements AuthenticationEntryPoint {
    private final static Logger logger = LoggerFactory.getLogger(JWTEntryPoint.class);

    @Override
    public void commence(HttpServletRequest req, HttpServletResponse resp, AuthenticationException authException) throws IOException, ServletException {
        //logger.error("Error en el Metodo Commence");
        //resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"No estas Autorizado");
        resp.setContentType("application/json");
        resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        //resp.sendError(HttpServletResponse.SC_UNAUTHORIZED,"No estas Autorizado");
        resp.getOutputStream().println("{ \"error\": \"" + authException.getMessage() + "\" }");

    }
}



