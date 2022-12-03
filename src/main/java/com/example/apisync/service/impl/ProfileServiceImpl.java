package com.example.apisync.service.impl;

import com.example.apisync.dto.request.ProfileRequest;
import com.example.apisync.dto.request.ProfileUpdateRequest;
import com.example.apisync.dto.response.ProfileResponse;
import com.example.apisync.exception.request.BadRequestException;
import com.example.apisync.exception.request.NotFoundException;
import com.example.apisync.model.Profile;
import com.example.apisync.repository.ProfileRepository;
import com.example.apisync.service.ProfileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProfileServiceImpl implements ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileResponse getById(Long id) {
        return profileRepository.findById(id)
                .map(ProfileResponse::toDto)
                .orElseThrow(() ->
                {
                    throw new BadRequestException("Cannot find profile with id " + id);
                });
    }

    @Override
    public List<ProfileResponse> update(List<ProfileUpdateRequest> requests) {
        if (requests != null) {
            List<ProfileResponse> responses = new ArrayList<>();

            for (ProfileUpdateRequest request : requests) {
                if (request.getId() == null) {
                    throw new NotFoundException("id is not found");
                }
                ProfileResponse profileResponse = getById(request.getId());

                Profile entity = ProfileResponse.toEntity(profileResponse);
                request.getFields().forEach((key, value) -> {
                    Field field = ReflectionUtils.findField(Profile.class, (String) key);
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, entity, value);
                });

                profileRepository.saveAndFlush(entity);
                responses.add(ProfileResponse.toDto(entity));
            }

            return responses;
        }
        return Collections.emptyList();
    }

    @Override
    public List<ProfileResponse> saveField() {
        return null;
    }

    @Override
    public List<ProfileResponse> save(List<ProfileRequest> requests) {
        if (!requests.isEmpty()) {
            List<ProfileResponse> responses = new ArrayList<>();

            for (ProfileRequest request : requests) {
                Profile entity = Profile.builder()
                        .number(request.getNumber())
                        .fullname(request.getFullname())
                        .age(request.getAge())
                        .build();

                profileRepository.save(entity);
                responses.add(ProfileResponse.toDto(entity));
            }

            return responses;
        }
        return Collections.emptyList();
    }


}
