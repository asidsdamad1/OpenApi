package com.example.apisync.dto.response;


import com.example.apisync.constant.Constants;
import com.example.apisync.dto.BaseDto;
import com.example.apisync.model.Profile;
import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileResponse extends BaseDto {
    private String number;
    private String fullname;
    private int age;

    public static Profile toEntity(ProfileResponse dto) {
        return Constants.map().convertValue(dto, Profile.class);
    }

    public static ProfileResponse toDto(Profile entity) {
        return Constants.map().convertValue(entity, ProfileResponse.class);
    }


}
