package com.example.apisync.dto.request;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class ProfileUpdateRequest {
    private Long id;
    private Map<Object, Object> fields;
}
