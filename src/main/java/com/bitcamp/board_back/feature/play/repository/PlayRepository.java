package com.bitcamp.board_back.feature.play.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bitcamp.board_back.feature.play.entity.PlayEntity;
import com.bitcamp.board_back.feature.play.repository.resultSet.GetPlayResultSet;

@Repository
public interface PlayRepository extends JpaRepository<PlayEntity, Integer> {

    boolean existsByPlayNumber(Integer playNumber);

    PlayEntity findByPlayNumber(Integer PlayNumber);

    @Query(value = "SELECT " +
            "P.play_number AS playNumber, " +
            "P.title AS title, " +
            "P.content AS content, " +
            "P.write_datetime AS writerDatetime, " +
            "P.writer_email AS writerEmail, " +
            "P.play AS play, " +
            "P.nickname AS writerNickname, " +
            "U.profile_image AS writerProfileImage " +
            "FROM play AS P " +
            "INNER JOIN user AS U " +
            "ON P.writer_email = U.email " +
            "WHERE play_number = ?1", nativeQuery = true)
    GetPlayResultSet getPlay(Integer playNumber);
}
