package com.example.apisync.rest;

import com.example.apisync.config.security.response.AuthenticationResponse;
import com.example.apisync.dto.request.UserRequest;
import com.example.apisync.service.AuthenticationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequiredArgsConstructor
@Api(value = "Authentication api")
public class RestAuthenticationController {
    private final AuthenticationService service;

    @ApiOperation(value = "signin", notes = "return information token")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Sign in successfully")
            }
    )
    @PostMapping(value = "/signin")
    public ResponseEntity<AuthenticationResponse> createAuthenticationToken(@RequestBody UserRequest userRequest) {
        return ResponseEntity.ok(service.createAuthenticationToken(userRequest));
    }

    @ApiOperation(value = "refresh token", notes = "return token is refreshed")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Get token successfully")
            }
    )
    @GetMapping(value = "/token/refresh")
    public ResponseEntity<AuthenticationResponse> refreshToken(HttpServletRequest request) {
        return ResponseEntity.ok(service.refreshToken(request));
    }
}
