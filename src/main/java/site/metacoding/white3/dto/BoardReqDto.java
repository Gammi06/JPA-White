package site.metacoding.white3.dto;

import lombok.Getter;
import lombok.Setter;
import site.metacoding.white3.domain.User;

public class BoardReqDto {

    @Getter
    @Setter
    public static class BoardSaveDto {
        private String title;
        private String content;

        // 클라이언트한테 받는 게 아님, 서비스 로직
        private User user;
    }
}
