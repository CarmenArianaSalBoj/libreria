/*package com.example.Libreria.security;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class ApiKeyFilter extends OncePerRequestFilter {

    @Value("${api.key}")
    private String configuredApiKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        String requestApiKey = request.getHeader("x-api-key");

        if (configuredApiKey.equals(requestApiKey)) {
            // API Key es válida, continuar con la solicitud
            filterChain.doFilter(request, response);
        } else {
            // API Key inválida, rechazar la solicitud
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            response.getWriter().write("Invalid API Key");
        }
    }
}*/
package com.example.Libreria.security;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

public class ApiKeyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Inicialización, si es necesario
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // Lógica de validación de la API Key
        String apiKey = request.getParameter("apiKey"); // O lo que sea que estés utilizando para obtener la clave

        if (apiKey == null || !isValidApiKey(apiKey)) {
            throw new ServletException("API Key is missing or invalid.");
        }

        chain.doFilter(request, response); // Pasa a la siguiente cadena de filtros
    }

    private boolean isValidApiKey(String apiKey) {
        // Lógica de validación de la API Key
        return "valid-api-key".equals(apiKey);
    }

    @Override
    public void destroy() {
        // Limpieza, si es necesario
    }
}
