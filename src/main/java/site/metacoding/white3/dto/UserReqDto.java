package site.metacoding.white3.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white3.domain.User;

public class UserReqDto {

    // 이름 규칙을 정할것
    // Req, Resp를 붙일지 말지

    @Setter
    @Getter
    public static class JoinReqDto {
        // 인증 관련 로직(로그인 전 로직)들은 전부 Entity를 붙이지 말것
        // post할때 /user => /join
        private String username;
        private String password;

        // Dto를 User로 바꿔서 리턴해주는 코드
        public User toEntity() {
            return User.builder().username(username).password(password).build();
        }
    }

    // 내부 클래스를 만들고 외부에서 사용하려면 static를 붙여줘야함
    // 외부에서 사용하지 않으면 static 안붙여도 됨
    @Setter
    @Getter
    public static class LoginReqDto {
        private String username;
        private String password;
    }

    @Setter
    @Getter
    public static class UpdateReqDto {
        // 인증 관련 로직(로그인 전 로직)들은 전부 Entity를 붙이지 말것
        // post할때 /user => /join
        private String username;
        private String password;

        // Dto를 User로 바꿔서 리턴해주는 코드
        public User toEntity() {
            return User.builder().username(username).password(password).build();
        }
    }
}
