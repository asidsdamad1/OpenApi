package com.example.apisync.service;


import com.example.apisync.dto.request.ProfileRequest;
import com.example.apisync.dto.request.ProfileUpdateRequest;
import com.example.apisync.dto.response.ProfileResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProfileService {
    List<ProfileResponse> update(List<ProfileUpdateRequest> requests);

    List<ProfileResponse> saveField();

    List<ProfileResponse> save(List<ProfileRequest> requests);

}
