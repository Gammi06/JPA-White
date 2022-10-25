package site.metacoding.white3.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.domain.User;
import site.metacoding.white3.domain.UserRepository;
import site.metacoding.white3.dto.SessionUser;
import site.metacoding.white3.dto.UserReqDto.JoinReqDto;
import site.metacoding.white3.dto.UserReqDto.LoginReqDto;
import site.metacoding.white3.dto.UserRespDto.JoinRespDto;

@RequiredArgsConstructor // 이거없으면 디폴트 생성자
@Service // 안붙이면 IoC에 안뜸
public class UserService {

    private final UserRepository userRepository;

    // 응답의 DTO는 서비스에서 만든다.
    // 트랜잭션을 붙여야 영속화 되어 있는 객체가 flush됨
    @Transactional
    public JoinRespDto save(JoinReqDto joinReqDto) {
        User userPS = userRepository.save(joinReqDto.toEntity());
        // System.out.println("ccc-out2: " + userPS.getId());
        return new JoinRespDto(userPS);
    }

    @Transactional(readOnly = true)
    public SessionUser login(LoginReqDto loginReqDto) {
        User userPS = userRepository.findByUsername(loginReqDto.getUsername());
        if (userPS.getPassword().equals(loginReqDto.getPassword())) {
            return new SessionUser(userPS);
        } else {
            throw new RuntimeException("아이디 혹은 비밀전호를 잘 못 입력하셨습니다.");
        }
    } // 트랜잭션 종료
}
