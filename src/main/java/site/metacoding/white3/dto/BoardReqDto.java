package site.metacoding.white3.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white3.domain.Board;

public class BoardReqDto {

    @Getter
    @Setter
    public static class BoardSaveReqDto {
        private String title;
        private String content;
        private SessionUser sessionUser;

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .user(sessionUser.toEntity())
                    .build();
        }
    }

    @Getter
    @Setter
    public static class BoardUpdateReqDto {
        private String title;
        private String content;
        private Long id;

        public Board toEntity() {
            return Board.builder()
                    .title(title)
                    .content(content)
                    .id(id)
                    .build();
        }
    }
}
