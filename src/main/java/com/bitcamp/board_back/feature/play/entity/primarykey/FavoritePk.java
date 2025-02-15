package com.bitcamp.board_back.feature.play.entity.primarykey;

import java.io.Serializable; // 이 부분 임의로 추가함

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FavoritePk implements Serializable {
    @Column(name = "user_email")
    private String userEmail;
    @Column(name = "board_number")
    private int boardNumber;
}