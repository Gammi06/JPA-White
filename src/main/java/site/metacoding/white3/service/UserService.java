package site.metacoding.white3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.domain.User;
import site.metacoding.white3.domain.UserRepository;

@RequiredArgsConstructor // 이거없으면 디폴트 생성자
@Service // 안붙이면 IoC에 안뜸
public class UserService {

    private final UserRepository userRepository;

    // 트랜잭션을 붙여야 영속화 되어 있는 객체가 flush됨
    @Transactional
    public void save(User user) {
        userRepository.save(user);
    }

    @Transactional(readOnly = true)
    public User login(User user) {
        User userPS = userRepository.findByUsername(user.getUsername());
        if (userPS.getPassword().equals(user.getPassword())) {
            return userPS;
        } else {
            throw new RuntimeException("아이디 혹은 비밀전호를 잘 못 입력하셨습니다.");
        }
    } // 트랜잭션 종료
}
