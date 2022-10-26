package site.metacoding.white3.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white3.domain.Board;
import site.metacoding.white3.domain.Comment;
import site.metacoding.white3.domain.User;

public class CommentRespDto {

    @Getter
    @Setter
    public static class CommentSaveRespDto {

        private Long id;
        private String content;

        private UserDto user;
        private BoardDto board;

        @Getter
        @Setter
        public static class UserDto {
            private Long id;
            private String username;

            public UserDto(User user) {
                this.id = user.getId();
                this.username = user.getUsername();
            }
        }

        @Getter
        @Setter
        public static class BoardDto {
            private Long id;

            public BoardDto(Board board) {
                this.id = board.getId();
            }
        }

        public CommentSaveRespDto(Comment comment) {
            this.id = comment.getId();
            this.content = comment.getContent();
            this.board = new BoardDto(comment.getBoard());
            this.user = new UserDto(comment.getUser());
        }
    }

}