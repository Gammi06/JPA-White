package site.metacoding.white3.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.dto.ResponseDto;
import site.metacoding.white3.dto.SessionUser;
import site.metacoding.white3.dto.UserReqDto.JoinReqDto;
import site.metacoding.white3.dto.UserReqDto.LoginReqDto;
import site.metacoding.white3.dto.UserRespDto.JoinRespDto;
import site.metacoding.white3.service.UserService;

@RestController
@RequiredArgsConstructor
public class UserApiController {

    private final UserService userService;
    private final HttpSession session;
    // repository와 service를 함께 사용하면 일관성이 없기 때문에
    // service로만 트랜젝션을 관리하는 것이 좋다

    // JSON으로 받을거니까 request body를 붙인다
    @PostMapping("/join")
    public ResponseDto<?> save(@RequestBody JoinReqDto joinReqDto) {
        JoinRespDto joinRespDto = userService.save(joinReqDto);
        return new ResponseDto<>(1, "ok", joinRespDto);
    }

    @PostMapping("/login")
    public ResponseDto<?> login(@RequestBody LoginReqDto loginReqDto) {
        SessionUser principal = userService.login(loginReqDto);
        session.setAttribute("principal", principal);
        return new ResponseDto<>(1, "ok", principal);
    }
}
