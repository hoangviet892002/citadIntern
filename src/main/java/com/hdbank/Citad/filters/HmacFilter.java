package com.hdbank.Citad.filters;

import com.hdbank.Citad.utils.HmacUtil;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


@Component
@RequiredArgsConstructor
public class HmacFilter extends OncePerRequestFilter {

    private final HmacUtil hmacUtil;

    @Override
    protected void doFilterInternal(
            HttpServletRequest request, HttpServletResponse response, FilterChain filterChain
    ) throws ServletException, IOException {

        final List<Pair<String, String>> bypassToken = Arrays.asList(
                Pair.of("/swagger-ui/index.html", "GET"),
                Pair.of("/v3/api-docs", "GET"),
                Pair.of("/swagger-ui/swagger-initializer.js", "GET")
        );

        // Check if the request needs to be bypassed
        for (Pair<String, String> bypasstoken : bypassToken) {
            if (request.getServletPath().contains(bypasstoken.getFirst())) {
                filterChain.doFilter(request, response);
                return;
            }
        }
       // Check if the request has a valid signature
        try {
            // Get the signature from the request
            String key = request.getHeader("Api-Key");
            System.out.println(key);
            if (key == null) {
                throw new ServletException("No valid Key provided");
            }
            // Verify the signature
            if (!hmacUtil.verifyHmac(key)) {
                throw new ServletException("Invalid Key");
            }
        } catch (Exception e) {
            throw new ServletException("Invalid Key");
        }
        filterChain.doFilter(request, response);
    }
}
