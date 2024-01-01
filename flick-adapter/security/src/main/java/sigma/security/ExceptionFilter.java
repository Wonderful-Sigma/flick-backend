package sigma.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import sigma.domain.common.exception.ErrorResponse;

import java.io.IOException;

@Component
@RequiredArgsConstructor
class ExceptionFilter extends OncePerRequestFilter {

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        try {
            filterChain.doFilter(request, response);
        } catch (ExpiredJwtException e) {
            setErrorResponse(response, 401, "만료된 토큰입니다.");
        } catch (MalformedJwtException e) {
            setErrorResponse(response, 400, "잘못된 토큰입니다.");
        } catch (UnsupportedJwtException e) {
            setErrorResponse(response, 400, "지원하지 않는 토큰입니다.");
        } catch (IllegalArgumentException e) {
            setErrorResponse(response, 400, "잘못된 인자입니다.");
        }
    }

    private void setErrorResponse(HttpServletResponse response, int status, String message) {
        try {
            responseToClient(response, ErrorResponse.of(status, message));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void responseToClient(HttpServletResponse response, ErrorResponse errorResponse) throws IOException {
        response.setStatus(errorResponse.status());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(objectMapper.writeValueAsString(errorResponse));
    }

}