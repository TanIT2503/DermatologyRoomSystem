package com.cdio.dermatologroomsystem.controller;

import com.cdio.dermatologroomsystem.jwt.JwtUtils;
import com.cdio.dermatologroomsystem.payload.request.LoginRequest;
import com.cdio.dermatologroomsystem.payload.response.JwtResponse;
import com.cdio.dermatologroomsystem.service.Impl.JwtServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping
public class BaseController {
    @Autowired
    private JwtServiceImpl jwtService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private JwtUtils jwtUtils;

    @PostMapping({"/authenticate"})
//    public JwtResponse createJwtToken(@RequestBody LoginRequest loginRequest) throws Exception {
//        return jwtService.createJwtToken(loginRequest);
//    }
    public ResponseEntity<?> createAuthenticationToken(@RequestBody LoginRequest loginRequest) throws Exception{
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getUserPassword())
            );
        }catch (BadCredentialsException e){
            throw new Exception("Incorrect username or password",e);
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUserName());
        final String jwt = jwtUtils.generateToken(userDetails);
        return ResponseEntity.ok(new JwtResponse(jwt));
    }
}
