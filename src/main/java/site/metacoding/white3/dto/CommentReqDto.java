package site.metacoding.white3.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white3.domain.Board;
import site.metacoding.white3.domain.Comment;

public class CommentReqDto {

    @Setter
    @Getter
    public static class CommentSaveReqDto {
        private String content;
        private Long boardId;
        private SessionUser sessionUser;
        // Board도 필요함

        public Comment toEntity(Board board) {
            Comment comment = Comment.builder()
                    .content(content)
                    .board(board)
                    .user(sessionUser.toEntity())
                    .build();
            return comment;
        }
    }
}
