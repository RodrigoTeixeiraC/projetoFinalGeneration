package com.gamificacao.projetogamificacao.Security;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.gamificacao.projetogamificacao.Models.Usuario;

public class UserDetailsImpl implements UserDetails {
	
	private static final long SerialVersionUID = 1L;
	
	private String userName;
	
	private String passWord;
	
	public UserDetailsImpl (Usuario user) {
		this.userName = user.getUsuario();
		this.passWord = user.getSenha();
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return null;
	}

	@Override
	public String getPassword() {
		return null;
	}

	@Override
	public String getUsername() {
		return null;
	}

	@Override
	public boolean isAccountNonExpired() {
		return false;
	}

	@Override
	public boolean isAccountNonLocked() {
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return false;
	}

	@Override
	public boolean isEnabled() {
		return false;
	}

}
