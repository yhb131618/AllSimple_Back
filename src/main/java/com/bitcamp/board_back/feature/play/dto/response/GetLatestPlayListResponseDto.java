package com.bitcamp.board_back.feature.play.dto.response;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bitcamp.board_back.common.ApiResponse;
import com.bitcamp.board_back.common.enums.ApiStatus;
import com.bitcamp.board_back.feature.play.dto.object.PlayListItem;
import com.bitcamp.board_back.feature.play.entity.PlayListViewEntity;

import lombok.Getter;

@Getter
public class GetLatestPlayListResponseDto extends ApiResponse {

    private List<PlayListItem> latestList;

    private GetLatestPlayListResponseDto(List<PlayListViewEntity> playEntities) {
        super(ApiStatus.SUCCESS.getCode(), ApiStatus.SUCCESS.getMessage());
        this.latestList = PlayListItem.getList(playEntities);
    }

    public static ResponseEntity<GetLatestPlayListResponseDto> success(List<PlayListViewEntity> playEntities) {
        GetLatestPlayListResponseDto result = new GetLatestPlayListResponseDto(playEntities);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
