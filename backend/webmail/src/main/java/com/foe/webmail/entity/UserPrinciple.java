package com.foe.webmail.entity;

import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;

@Getter
public class UserPrinciple implements UserDetails {
    private final User user;

    public UserPrinciple(User user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.emptyList(); // No roles in this implementation
    }

    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true; // You can add custom logic here
    }

    @Override
    public boolean isAccountNonLocked() {
        return true; // You can add custom logic here
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true; // You can add custom logic here
    }

    @Override
    public boolean isEnabled() {
        return true; // You can add custom logic here
    }
}
