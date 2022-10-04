package fr.eni.filmotheque.services;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import fr.eni.filmotheque.bo.User;

public class MyUserPrincipal implements UserDetails {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private User user;
	private List<GrantedAuthority> authorities;

	public MyUserPrincipal(User user) {
		this.user = user;
		if (user.isAdmin()) {
			this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"),
					new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else {
			this.authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return authorities;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		System.out.println("getUSRNAME");
		System.out.println(user.getUsername());
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
