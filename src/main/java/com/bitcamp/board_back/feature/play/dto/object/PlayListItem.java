package com.bitcamp.board_back.feature.play.dto.object;

import java.util.ArrayList;
import java.util.List;

import com.bitcamp.board_back.feature.play.entity.PlayListViewEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PlayListItem {
    private int playNumber;
    private String title;
    private String content;
    private String play;
    private int favoriteCount;
    private int commentCount;
    private int viewCount;
    private String writeDatetime;
    private String writerNickname;
    private String writerProfileImage;

    public PlayListItem(PlayListViewEntity playListViewEntity) {
        this.playNumber = playListViewEntity.getPlayNumber();
        this.title = playListViewEntity.getTitle();
        this.content = playListViewEntity.getContent();
        this.play = playListViewEntity.getPlay();
        this.favoriteCount = playListViewEntity.getFavoriteCount();
        this.commentCount = playListViewEntity.getCommentCount();
        this.viewCount = playListViewEntity.getViewCount();
        this.writeDatetime = playListViewEntity.getWriteDatetime();
        this.writerNickname = playListViewEntity.getWriterNickname();
        this.writerProfileImage = playListViewEntity.getWriterProfileImage();

    }

    public static List<PlayListItem> getList(List<PlayListViewEntity> playListViewEntities) {
        List<PlayListItem> list = new ArrayList<>();
        for (PlayListViewEntity playListViewEntity : playListViewEntities) {
            PlayListItem playListItem = new PlayListItem(playListViewEntity);
            list.add(playListItem);
        }
        return list;
    }
}
