package com.bitcamp.board_back;

import static com.bitcamp.board_back.common.log.YellowBoardLogger.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BoardBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoardBackApplication.class, args);
		logServerStart();
	}
}
