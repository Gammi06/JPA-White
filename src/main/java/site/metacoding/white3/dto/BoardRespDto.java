package site.metacoding.white3.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.white3.domain.Board;
import site.metacoding.white3.domain.User;

public class BoardRespDto {

    @NoArgsConstructor
    @Getter
    @Setter
    public static class BoardSaveRespDto {
        private Long id;
        private String title;
        private String content;
        private UserDto user;

        // 재사용 방법을 정해야 함 (일관성 만들기)
        // 1. 엔티티 쓰기
        // 2. 다른 Dto 재사용하기
        // 3. 내부 class 제작함
        @Setter
        @Getter
        public static class UserDto {
            private Long id;
            private String username;

            public UserDto(User user) {
                this.id = user.getId();
                this.username = user.getUsername();
            }
        }

        public BoardSaveRespDto(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.user = new UserDto(board.getUser());
        }
    }
}
