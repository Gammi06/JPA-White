package site.metacoding.white3.web;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.domain.User;
import site.metacoding.white3.domain.UserJpaRepository;
import site.metacoding.white3.dto.ResponseDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RequiredArgsConstructor
@RestController
public class UserJpaApiController {
    private final UserJpaRepository userJpaRepository;

    // findById, findAll, save, deleteById
    // 기본적인 CRUD 메소드가 구현되어 있음

    @GetMapping("/jpa/user/{id}")
    public ResponseDto<?> findById(@PathVariable Long id) {
        Optional<User> userOP = userJpaRepository.findById(id);
        if (userOP.isPresent()) {
            return new ResponseDto<>(1, "성공", userOP.get());
        } else {
            throw new RuntimeException("해당 사용자를 찾을 수 없습니다.");
        }
    }

    @GetMapping("/jpa/user")
    public ResponseDto<?> findAll(Integer page) {
        PageRequest pageRequest = PageRequest.of(page, 1);
        Page<User> userList = userJpaRepository.findAll(pageRequest);
        return new ResponseDto<>(1, "성공", userList);
    }

    @PostMapping("/jpa/join")
    public ResponseDto<?> save(@RequestBody User user) {
        User userPS = userJpaRepository.save(user);
        return new ResponseDto<>(1, "성공", userPS);
    }

    @PostMapping("/jpa/login")
    public ResponseDto<?> login(@RequestBody User user) {
        User userPS = userJpaRepository.findByUsername(user.getUsername());
        if (userPS.getPassword().equals(user.getPassword())) {
            return new ResponseDto<>(1, "성공", userPS);
        } else {
            throw new RuntimeException("아이디 비밀번호가 틀렸습니다.");
        }
    }

}
