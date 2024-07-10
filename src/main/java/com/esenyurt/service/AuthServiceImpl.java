package com.esenyurt.service;

import com.esenyurt.dto.LoginDto;
import com.esenyurt.dto.SignUpDto;
import com.esenyurt.entity.User;
import com.esenyurt.repository.RoleRepository;
import com.esenyurt.repository.UserRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public String authenticateUser(LoginDto loginDto, HttpServletRequest request){
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginDto.username(), loginDto.password()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        HttpSession session = request.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        return "User signed-in successfully!.";
    }

    public String registerUser( SignUpDto signUpDto){

        if(userRepository.existsByUsername(signUpDto.username())){
            return "Username is already taken!";
        }

        User user = new User();
        user.setPersonId(signUpDto.personId());
        user.setUserName(signUpDto.username());
        user.setPassword(passwordEncoder.encode(signUpDto.password()));

        userRepository.save(user);
        return "User registered successfully";

    }

    public String logout(HttpServletRequest request){

        SecurityContextHolder.getContext().setAuthentication(null);

        SecurityContextHolder.clearContext();

        HttpSession session = request.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        SecurityContextHolder.clearContext();
        return "User logged out successfully";

    }
}
