package site.metacoding.white3.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.domain.Board;
import site.metacoding.white3.domain.BoardRepository;
import site.metacoding.white3.dto.BoardReqDto.BoardSaveReqDto;
import site.metacoding.white3.dto.BoardRespDto.BoardSaveRespDto;

@RequiredArgsConstructor // 이거없으면 디폴트 생성자
@Service // 안붙이면 IoC에 안뜸
public class BoardService {

    private final BoardRepository boardRepository;

    @Transactional
    public BoardSaveRespDto save(BoardSaveReqDto boardSaveReqDto) {
        // 핵심 로직
        Board boardPS = boardRepository.save(boardSaveReqDto.toEntity());

        // DTO 전환
        BoardSaveRespDto boardSaveRespDto = new BoardSaveRespDto(boardPS);
        return boardSaveRespDto;
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
        if (boardPS != null) {
            boardPS.update(board.getTitle(), board.getContent());
            // 트렌젝션이 종료 시 더티체킹을 함 + flush
        } else {
            throw new RuntimeException("해당 id를 찾을 수 없습니다.");
        }
    }

    @Transactional
    public void deleteById(Long id) {
        boardRepository.deleteById(id);
    }
}
