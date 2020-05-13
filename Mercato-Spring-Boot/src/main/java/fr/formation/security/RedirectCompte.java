package fr.formation.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class RedirectCompte implements AuthenticationSuccessHandler {

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication auth) throws IOException, ServletException {
		if (auth.getAuthorities()
				.stream()
				.filter(r -> r.getAuthority().equals("ROLE_MANAGER"))
				.findFirst().isPresent()) {
			response.sendRedirect("/Menu_Manager");
		}
		
		else {
			response.sendRedirect("/Menu_Joueur");
		}
	}

}