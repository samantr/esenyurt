package com.esenyurt.audit;


import java.util.Optional;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;

public class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username;
        if (authentication == null || !authentication.isAuthenticated()) {
            return null;
        }

        User user;
        if (authentication.getPrincipal() instanceof User)
        {
            user = ((User)authentication.getPrincipal());
            username = user.getUsername();
        }
        else
            username = authentication.getPrincipal().toString();

        return  Optional.of(username);
    }
}

// ------------------ Use below code for spring security --------------------------

/*class SpringSecurityAuditorAware implements AuditorAware<User> {

 public User getCurrentAuditor() {

  Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

  if (authentication == null || !authentication.isAuthenticated()) {
   return null;
  }

  return ((MyUserDetails) authentication.getPrincipal()).getUser();
 }
}*/