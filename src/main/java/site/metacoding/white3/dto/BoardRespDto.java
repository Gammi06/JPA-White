package site.metacoding.white3.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import site.metacoding.white3.domain.Board;
import site.metacoding.white3.domain.Comment;
import site.metacoding.white3.domain.User;
import site.metacoding.white3.dto.BoardRespDto.BoardDetailRespDto.CommentDto.CommentUserDto;

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

    @NoArgsConstructor
    @Getter
    @Setter
    public static class BoardDetailRespDto { // 이름 규칙도 잡아줘야 함
        private Long id;
        private String title;
        private String content;
        private BoardUserDto user;
        private List<CommentDto> comment = new ArrayList<>();

        // 재사용 방법을 정해야 함 (일관성 만들기)
        // 1. 엔티티 쓰기
        // 2. 다른 Dto 재사용하기
        // 3. 내부 class 제작함
        @Setter
        @Getter
        public static class BoardUserDto {
            private Long id;
            private String username;

            public BoardUserDto(User user) {
                this.id = user.getId(); // lazy
                this.username = user.getUsername(); // lazy
            }
        }

        @Setter
        @Getter
        public static class CommentDto {
            private Long id;
            private String content;
            private CommentUserDto user;

            public CommentDto(Comment comment) {
                this.id = comment.getId();
                this.content = comment.getContent();
                this.user = new CommentUserDto(comment.getUser());
            }

            @Setter
            @Getter
            public static class CommentUserDto {
                private Long id;
                private String username;

                public CommentUserDto(User user) {
                    this.id = user.getId(); // lazy
                    this.username = user.getUsername(); // lazy
                }
            }
        }

        public BoardDetailRespDto(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.user = new BoardUserDto(board.getUser());
            // List<CommentDto> <--- List<Comment>
            this.comment = board.getComments().stream()
                    .map((comment) -> new CommentDto(comment))
                    .collect(Collectors.toList());
        }
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class BoardWriteRespDto { // 이름 규칙도 잡아줘야 함
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

        public BoardWriteRespDto(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.user = new UserDto(board.getUser());
        }
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class BoardAllListRespDto { // 이름 규칙도 잡아줘야 함
        private Long id;
        private String title;
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

        public BoardAllListRespDto(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.user = new UserDto(board.getUser());
        }
    }

    @NoArgsConstructor
    @Getter
    @Setter
    public static class BoardUpdateRespDto { // 이름 규칙도 잡아줘야 함
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

            public UserDto(User user) {
                this.id = user.getId();
            }
        }

        public BoardUpdateRespDto(Board board) {
            this.id = board.getId();
            this.title = board.getTitle();
            this.content = board.getContent();
            this.user = new UserDto(board.getUser());
        }
    }
}
