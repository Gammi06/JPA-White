package site.metacoding.white3.service;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.domain.BoardRepository;

@RequiredArgsConstructor // 이거없으면 디폴트 생성자
@Service // 안붙이면 IoC에 안뜸
public class BoardService {

    private final BoardRepository boardRepository;

    public void save() {
        boardRepository.save(null);
    }
}
