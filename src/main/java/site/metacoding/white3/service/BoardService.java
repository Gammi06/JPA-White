package site.metacoding.white3.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.domain.Board;
import site.metacoding.white3.domain.BoardRepository;

@RequiredArgsConstructor // 이거없으면 디폴트 생성자
@Service // 안붙이면 IoC에 안뜸
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public void save(Board board) {
        boardRepository.save(board);
    }

    public Board findById(Long id) {
        return boardRepository.findById(id);
    }

    public List<Board> finAll() {
        return boardRepository.findAll();
    }

    @Transactional
    public void update(Long id, Board board) {
        Board boardPS = boardRepository.findById(id);

        /*
         * if (boardPS == null) {
         * throw new RuntimeException("해당 id를 찾을 수 없습니다.");
         * }
         */

        // 영속화된 데이터를 수정함
        boardPS.setTitle(board.getTitle());
        boardPS.setContent(board.getContent());
        boardPS.setAuthor(board.getAuthor());
        // 트렌젝션이 종료 시 더티체킹을 함 + flush
    }

    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
