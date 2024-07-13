package com.bitcamp.board_back.feature.play.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bitcamp.board_back.feature.play.entity.PlayListViewEntity;

@Repository
public interface PlayListViewRepository extends JpaRepository<PlayListViewEntity, Integer> {

        List<PlayListViewEntity> findByOrderByWriteDatetimeDesc();

        List<PlayListViewEntity> findTop3ByWriteDatetimeGreaterThanOrderByFavoriteCountDescCommentCountDescViewCountDescWriteDatetimeDesc(
                        String writeDatetime);

        List<PlayListViewEntity> findByTitleContainsOrContentContainsOrderByWriteDatetimeDesc(String title,
                        String content);

        List<PlayListViewEntity> findByWriterEmailOrderByWriteDatetimeDesc(String writerEmail);
}
