package site.metacoding.white3.web;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.domain.User;
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
    public String save(@RequestBody User user) {
        userService.save(user);
        return "ok";
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        User principal = userService.login(user);
        session.setAttribute("principal", principal);
        return "login";
    }
}
