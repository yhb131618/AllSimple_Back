package com.bitcamp.board_back.feature.play.service.implement;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bitcamp.board_back.common.ApiResponse;
import com.bitcamp.board_back.feature.play.dto.request.PostPlayRequestDto;
import com.bitcamp.board_back.feature.play.dto.response.GetLatestPlayListResponseDto;
import com.bitcamp.board_back.feature.play.dto.response.GetPlayResponseDto;
import com.bitcamp.board_back.feature.play.dto.response.IncreasePlayViewCountResponseDto;
import com.bitcamp.board_back.feature.play.dto.response.PostPlayResponseDto;
import com.bitcamp.board_back.feature.play.entity.PlayEntity;
import com.bitcamp.board_back.feature.play.entity.PlayListViewEntity;
import com.bitcamp.board_back.feature.play.repository.PlayListViewRepository;
import com.bitcamp.board_back.feature.play.repository.PlayRepository;
import com.bitcamp.board_back.feature.play.repository.resultSet.GetPlayResultSet;
import com.bitcamp.board_back.feature.play.service.PlayService;
import com.bitcamp.board_back.feature.user.dto.AccountUserDetails;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlayServiceImplement implements PlayService {

    private final PlayListViewRepository playListViewRepository;
    private final PlayRepository playRepository;

    @Override
    public ResponseEntity<? super GetPlayResponseDto> getPlay(Integer playNumber) {

        GetPlayResultSet resultSet = null;

        try {
            resultSet = playRepository.getPlay(playNumber);

            if (resultSet == null)
                return GetPlayResponseDto.notExistPlay();

            // BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            // boardEntity.increaseViewCount();
            // boardRepository.save(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ApiResponse.databaseError();
        }

        return GetPlayResponseDto.success(resultSet);
    }

    @Override
    public ResponseEntity<? super PostPlayResponseDto> postPlay(PostPlayRequestDto dto,
            AccountUserDetails accountUserDetails) {

        try {
            String email = accountUserDetails.getUser().getEmail();
            // email 검증부분이 필요함

            PlayEntity playEntity = new PlayEntity(dto, email);
            playRepository.save(playEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return ApiResponse.databaseError();

        }

        return PostPlayResponseDto.success();

    }

    @Override
    public ResponseEntity<? super GetLatestPlayListResponseDto> getLatestPlayList() {

        List<PlayListViewEntity> playListViewEntities = new ArrayList<>();

        try {

            playListViewEntities = playListViewRepository.findByOrderByWriteDatetimeDesc();

        } catch (Exception exception) {
            exception.printStackTrace();
            return ApiResponse.databaseError();
        }

        return GetLatestPlayListResponseDto.success(playListViewEntities);
    }

    @Override
    public ResponseEntity<? super IncreasePlayViewCountResponseDto> increasePlayViewCount(Integer playNumber) {

        try {
            PlayEntity playEntity = playRepository.findByPlayNumber(playNumber);
            if (playEntity == null)
                return IncreasePlayViewCountResponseDto.notExistPlay();

            playEntity.increasePlayViewCount();
            playRepository.save(playEntity);
        } catch (Exception exception) {
            exception.printStackTrace();
            return ApiResponse.databaseError();
        }

        return IncreasePlayViewCountResponseDto.success();
    }

}