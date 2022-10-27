package site.metacoding.white3.service;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import site.metacoding.white3.domain.Board;
import site.metacoding.white3.domain.BoardRepository;
import site.metacoding.white3.domain.Comment;
import site.metacoding.white3.domain.CommentRepository;
import site.metacoding.white3.dto.CommentReqDto.CommentSaveReqDto;
import site.metacoding.white3.dto.CommentRespDto.CommentSaveRespDto;

@Slf4j
@RequiredArgsConstructor // 이거없으면 디폴트 생성자
@Service // 안붙이면 IoC에 안뜸
public class CommentService {

    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;

    @Transactional
    public CommentSaveRespDto save(CommentSaveReqDto commentSaveReqDto) {
        // 1. Board가 있는지 확인
        Optional<Board> boardOP = boardRepository.findById(commentSaveReqDto.getBoardId());
        if (boardOP.isPresent()) {
            // 2. Comment 객체 만들기
            Comment comment = commentSaveReqDto.toEntity(boardOP.get());
            Comment commentPS = commentRepository.save(comment);
            CommentSaveRespDto commentSaveRespDto = new CommentSaveRespDto(commentPS);
            return commentSaveRespDto;
        } else {
            throw new RuntimeException("ccc: 게시글이 없습니다.");
        }
    }

    @Transactional
    public void deleteById(Long id) {
        // 1. comment가 있는지 확인
        Optional<Comment> commentOP = commentRepository.findById(id);
        if (commentOP.isPresent()) {
            // 2. comment 삭제
            commentRepository.deleteById(id);
        } else {
            throw new RuntimeException("ccc: 해당 코멘트(" + id + ")를 삭제할 수 없습니다.");
        }
    }
}
