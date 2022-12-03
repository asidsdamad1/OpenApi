package com.example.apisync.dto.request;


import com.example.apisync.constant.Constants;
import com.example.apisync.dto.BaseDto;
import com.example.apisync.model.Profile;
import lombok.*;

import java.util.Map;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileRequest extends BaseDto {
    private String number;
    private String fullname;
    private int age;

    public static Profile toEntity(ProfileRequest dto) {
        return Constants.map().convertValue(dto, Profile.class);
    }

    public static ProfileRequest toDto(Profile entity) {
        return Constants.map().convertValue(entity, ProfileRequest.class);
    }
}
