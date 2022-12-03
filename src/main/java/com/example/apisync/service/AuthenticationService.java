package com.example.apisync.service;

import com.example.apisync.dto.request.UserRequest;
import com.example.apisync.config.security.response.AuthenticationResponse;

import javax.servlet.http.HttpServletRequest;

public interface AuthenticationService {
    AuthenticationResponse createAuthenticationToken(UserRequest userRequest);

    AuthenticationResponse refreshToken(HttpServletRequest request);
}
