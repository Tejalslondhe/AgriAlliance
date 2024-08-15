package com.app.security;


import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.app.entities.Doctor;
import com.app.entities.Farmer;
import com.app.entities.Merchant;
import com.app.entities.User;
import com.app.entities.Worker;

public class CustomUserDetails implements UserDetails {

    private final User user;

    public CustomUserDetails(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // Convert the role to SimpleGrantedAuthority
        return List.of(new SimpleGrantedAuthority(user.getRole().name()));
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getEmail();
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

    public User getUser() {
        return user;
    }
    
    public Long getUserId() {
        if (user instanceof Farmer) {
            return ((Farmer) user).getFarmerId();
        } else if (user instanceof Worker) {
            return ((Worker) user).getWorkerId();
        } else if (user instanceof Merchant) {
            return ((Merchant) user).getMerchantId();
        } else if (user instanceof Doctor) {
            return ((Doctor) user).getDoctorId();
        }
        throw new IllegalStateException("Unknown user type");
    }
}


	
	

