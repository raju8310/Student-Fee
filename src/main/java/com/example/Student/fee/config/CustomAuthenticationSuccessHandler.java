package com.example.Student.fee.config;

import java.io.IOException;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		for (GrantedAuthority authority : authentication.getAuthorities()) {
			String role = authority.getAuthority();

			if (role.equals("ROLE_ADMIN")) {
				response.sendRedirect("/admin/dashboard");
				return;
			}
 			if (role.equals("ROLE_STUDENT")) {
				response.sendRedirect("/student/dashboard");
				return;
			}
		}
		response.sendRedirect("/login?error");
	}

}
