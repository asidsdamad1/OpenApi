package com.example.apisync.config.security.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String accessToken;
    private int expired;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;

    public AuthenticationResponse(String accessToken, int expired) {
        this.accessToken = accessToken;
        this.expired = expired;
    }
}
