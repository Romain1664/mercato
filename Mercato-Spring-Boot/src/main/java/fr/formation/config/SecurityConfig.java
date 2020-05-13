package fr.formation.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import fr.formation.security.RedirectCompte;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Profile("!dev")
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/static/**").permitAll()
		.antMatchers("/Menu_Manager/**").hasAnyRole("ADMIN","MANAGER")
		.antMatchers("/Menu_Joueur/**").hasAnyRole("ADMIN","JOUEUR")
		.antMatchers("/Liste_Joueurs").hasAnyRole("ADMIN","JOUEUR","MANAGER")
		.antMatchers("/**").permitAll()
		.and()
		.formLogin()
			.loginPage("/connection") // Lien vers le @GetMapping
			.loginProcessingUrl("/connection") //Lien du Post du form html
			.failureUrl("/connection?error") // Page d'erreur de connexion
//			.defaultSuccessUrl("/visite", true)
			.successHandler(new RedirectCompte())
			.permitAll()
			;
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

