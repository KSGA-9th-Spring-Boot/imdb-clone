package io.kimleang.springmvc.handler;

import io.kimleang.springmvc.model.auth.ERole;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request,
                                        HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {
        HttpSession session = request.getSession();
        session.setMaxInactiveInterval(24 * 60 * 60);

        String redirectUrl = (String) request.getSession().getAttribute("REDIRECT_SUCCESS_URL");

        if(redirectUrl != null) {
            response.setStatus(HttpServletResponse.SC_OK);
            for (GrantedAuthority auth : authentication.getAuthorities()) {
                if (ERole.ROLE_ADMIN.name().equals(auth.getAuthority())) {
                    response.sendRedirect("/admin");
                    return;
                }
            }
        }
        if(redirectUrl == null) {
            response.sendRedirect("/");
            return;
        }
        response.sendRedirect(redirectUrl);
    }
}
