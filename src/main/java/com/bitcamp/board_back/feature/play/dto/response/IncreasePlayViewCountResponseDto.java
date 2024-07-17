package com.bitcamp.board_back.feature.play.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bitcamp.board_back.common.ApiResponse;
import com.bitcamp.board_back.common.enums.ApiStatus;

public class IncreasePlayViewCountResponseDto extends ApiResponse {

    private IncreasePlayViewCountResponseDto() {
        super(ApiStatus.SUCCESS.getCode(), ApiStatus.SUCCESS.getMessage());
    }

    public static ResponseEntity<ApiResponse> success() {
        IncreasePlayViewCountResponseDto result = new IncreasePlayViewCountResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
