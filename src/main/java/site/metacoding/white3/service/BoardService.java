package site.metacoding.white3.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import site.metacoding.white3.domain.Board;
import site.metacoding.white3.domain.BoardRepository;
import site.metacoding.white3.dto.BoardReqDto.BoardSaveReqDto;
import site.metacoding.white3.dto.BoardReqDto.BoardUpdateReqDto;
import site.metacoding.white3.dto.BoardRespDto.BoardAllListRespDto;
import site.metacoding.white3.dto.BoardRespDto.BoardDetailRespDto;
import site.metacoding.white3.dto.BoardRespDto.BoardSaveRespDto;
import site.metacoding.white3.dto.BoardRespDto.BoardUpdateRespDto;

@Slf4j
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

    @Transactional(readOnly = true) // 트랜잭션을 걸면 OSIV가 false여도 디비 커넥션이 유지됨.
    public BoardDetailRespDto findById(Long id) {
        Optional<Board> boardOP = boardRepository.findById(id);
        if (boardOP.isEmpty() || !boardOP.isPresent()) {
            throw new RuntimeException("해당 id를 찾을 수 없습니다.");
        }
        BoardDetailRespDto boardDetailRespDto = new BoardDetailRespDto(boardOP.get());
        return boardDetailRespDto;
    }

    @Transactional(readOnly = true)
    public List<BoardAllListRespDto> finAll() {
        List<Board> boardList = boardRepository.findAll();
        // 1. List의 크기만큼 for문 돌리기
        // 2. Board - > DTO로 옮겨야 함
        // 3. DTO를 List에 담기
        List<BoardAllListRespDto> boardAllListRespDtos = new ArrayList<>();
        for (int i = 0; i < boardList.size(); i++) {
            boardAllListRespDtos.add(i, new BoardAllListRespDto(boardList.get(i)));
        }
        return boardAllListRespDtos;
    }

    @Transactional
    public BoardUpdateRespDto update(BoardUpdateReqDto boardUpdateReqDto) {
        Optional<Board> boardOP = boardRepository.findById(boardUpdateReqDto.getId());
        if (!boardOP.isPresent()) {
            throw new RuntimeException("해당 id를 찾을 수 없습니다.");
        }
        Board boardPS = boardOP.get();
        boardOP.get().update(boardUpdateReqDto.getTitle(), boardUpdateReqDto.getContent());
        return new BoardUpdateRespDto(boardPS);
    }

    @Transactional
    public void deleteById(Long id) {
        Optional<Board> boardOP = boardRepository.findById(id);
        if (!boardOP.isPresent()) {
            throw new RuntimeException("해당 id를 찾을 수 없습니다.");
        }
        boardRepository.deleteById(id);
    }
}
