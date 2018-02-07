package com.mdc.security;

import com.mdc.model.RoleModel;
import com.mdc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {

    private final UserService userService;

    @Autowired
    public CustomUserDetailsService(UserService userService) {
        this.userService = userService;
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        UserDetails user = userService.getUserByName(username);
        if(user == null) {
            throw new UsernameNotFoundException("[1] - Bad credentials");
        }

        return user;
    }

    /**
     * Retrieves a collection of {@link GrantedAuthority} based on a numerical
     * role
     *
     * @param roles
     *            the numerical role
     * @return a collection of {@link GrantedAuthority
     *
     */
    public Collection<? extends GrantedAuthority> getAuthorities(Collection<RoleModel> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (RoleModel role : roles) {
            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
        }
        return authorities;
    }
}
