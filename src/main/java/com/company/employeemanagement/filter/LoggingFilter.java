package com.company.employeemanagement.filter;

import java.io.IOException;

import org.springframework.stereotype.Component;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class LoggingFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        long start = System.currentTimeMillis();

        chain.doFilter(req, res);

        long time = System.currentTimeMillis() - start;
        HttpServletResponse response = (HttpServletResponse) res;

        System.out.println("Method: " + request.getMethod());
        System.out.println("Endpoint: " + request.getRequestURI());
        System.out.println("Status: " + response.getStatus());
        System.out.println("Time: " + time + "ms");
    }
}
