package com.esenyurt.controller;

import com.esenyurt.dto.LoginDto;
import com.esenyurt.dto.SignUpDto;
import com.esenyurt.service.AuthServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/auth")
public class AuthController {

    @Autowired
    private AuthServiceImpl authService;

    @PostMapping("/signin")
    public ResponseEntity<String> authenticateUser(@RequestBody LoginDto loginDto, HttpServletRequest request){

        return new ResponseEntity<>(authService.authenticateUser(loginDto, request), HttpStatus.OK);
    }

    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@RequestBody SignUpDto signUpDto){

        return new ResponseEntity<>(authService.registerUser(signUpDto), HttpStatus.OK);

    }

    @GetMapping("/logout")
    public ResponseEntity<?> logout(HttpServletRequest request){

        SecurityContextHolder.getContext().setAuthentication(null);

        SecurityContextHolder.clearContext();

        HttpSession session = request.getSession();
        session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

        SecurityContextHolder.clearContext();
        return new ResponseEntity<>("User logged out successfully", HttpStatus.OK);

    }
}