package com.example.apisync.rest;


import com.example.apisync.dto.request.ProfileRequest;
import com.example.apisync.dto.request.ProfileUpdateRequest;
import com.example.apisync.dto.response.ProfileResponse;
import com.example.apisync.service.ProfileService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/profile")
@Api(value = "Profile api")
public class RestProfileController {
    private final ProfileService profileService;

    @ApiOperation(value = "save profiles", notes = "return list profiles")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Save successfully")
            }
    )
    @PostMapping("/")
    public ResponseEntity<List<ProfileResponse>> save(@RequestBody List<ProfileRequest> requests) {
        return ResponseEntity.ok(profileService.save(requests));
    }

    @ApiOperation(value = "update profiles", notes = "return list profiles")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 200, message = "Update successfully"),
                    @ApiResponse(code = 404, message = "Id can not be null")
            }
    )

    @PatchMapping("/")
    public ResponseEntity<List<ProfileResponse>> update(@RequestBody List<ProfileUpdateRequest> requests) {
        return ResponseEntity.ok(profileService.update(requests));
    }

}
