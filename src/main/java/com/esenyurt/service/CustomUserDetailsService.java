package com.esenyurt.service;

import com.esenyurt.entity.User;
import com.esenyurt.repository.RoleRepository;
import com.esenyurt.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;

    public CustomUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() ->
                        new UsernameNotFoundException("User not found with username: "+ username));

        Set<GrantedAuthority> authorities = roleRepository.findByUser(user.getId())
                .stream()
                .map((role) -> new SimpleGrantedAuthority(role.getRoleName())).collect(Collectors.toSet());



        return new org.springframework.security.core.userdetails.User(user.getUserName(),
                user.getPassword(),
                authorities);
    }
}