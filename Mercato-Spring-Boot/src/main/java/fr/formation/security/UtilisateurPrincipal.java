package fr.formation.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import fr.formation.model.Compte;

public class UtilisateurPrincipal implements UserDetails {

	private static final long serialVersionUID = 1L;

	private Compte compte;
	
	public UtilisateurPrincipal(Compte utilisateur) {
		if (utilisateur == null) 
		{
			throw new UsernameNotFoundException("L'utilisateur n'existe pas.");
		}
		this.compte = utilisateur;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<GrantedAuthority> myAuthorities = new ArrayList<GrantedAuthority>();
		
		if (this.compte.getType().equals("Joueur"))
		{
			myAuthorities.add(new SimpleGrantedAuthority("ROLE_JOUEUR"));
		}
		else if (this.compte.getType().equals("Manager"))
		{
			myAuthorities.add(new SimpleGrantedAuthority("ROLE_MANAGER"));
		}
		return myAuthorities;
	}

	@Override
	public String getPassword() {
		return this.compte.getPassword();
	}

	@Override
	public String getUsername() {
		return this.compte.getLogin();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}