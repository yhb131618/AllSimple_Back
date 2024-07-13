package com.bitcamp.board_back.feature.play.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "play_list_view")
@Table(name = "play_list_view")
public class PlayListViewEntity {

    @Id
    private int playNumber;
    private String title;
    private String content;
    @Column(columnDefinition = "TEXT")
    private String play;
    private int viewCount;
    private int favoriteCount;
    private int commentCount;
    private String writeDatetime;
    private String writerEmail;
    private String writerNickname;
    private String writerProfileImage;

}
