package com.bitcamp.board_back.feature.play.dto.response;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.bitcamp.board_back.common.ApiResponse;
import com.bitcamp.board_back.common.enums.ApiStatus;
import com.bitcamp.board_back.feature.play.repository.resultSet.GetPlayResultSet;

import lombok.Getter;

@Getter
public class GetPlayResponseDto extends ApiResponse {

    private int playNumber;
    private String title;
    private String content;
    private String play;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;

    private GetPlayResponseDto(GetPlayResultSet resultSet) {
        super(ApiStatus.SUCCESS.getCode(), ApiStatus.SUCCESS.getMessage());

        this.playNumber = resultSet.getPlayNumber();
        this.title = resultSet.getTitle();
        this.content = resultSet.getContent();
        this.play = resultSet.getPlay();
        this.writeDatetime = resultSet.getWriterDatetime();
        this.writerEmail = resultSet.getWriterEmail();
        this.writerNickname = resultSet.getWriterNickname();
        this.writerProfileImage = resultSet.getWriterProfileImage();
    }

    public static ResponseEntity<GetPlayResponseDto> success(GetPlayResultSet resultSet) {
        GetPlayResponseDto result = new GetPlayResponseDto(resultSet);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
