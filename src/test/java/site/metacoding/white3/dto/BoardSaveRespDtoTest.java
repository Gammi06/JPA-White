package site.metacoding.white3.dto;

import org.junit.jupiter.api.Test;

import site.metacoding.white3.dto.BoardRespDto.BoardSaveRespDto;
import site.metacoding.white3.dto.BoardRespDto.BoardSaveRespDto.UserDto;

public class BoardSaveRespDtoTest {

    @Test
    public void innerClass_테스트() {
        BoardSaveRespDto boardSaveRespDto = new BoardSaveRespDto();
        boardSaveRespDto.setId(1L);
        boardSaveRespDto.setTitle("제목1");
        boardSaveRespDto.setContent("내용1");
        boardSaveRespDto.setUser(null);

        // UserDto userDto = new UserDto();
        // userDto.setId(12d);
        // userDto.setUsername("머고");
    }
}
