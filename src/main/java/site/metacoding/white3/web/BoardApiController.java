package site.metacoding.white3.web;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.domain.Board;
import site.metacoding.white3.dto.BoardReqDto.BoardSaveReqDto;
import site.metacoding.white3.dto.ResponseDto;
import site.metacoding.white3.dto.SessionUser;
import site.metacoding.white3.service.BoardService;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    private final HttpSession session;
    private final BoardService boardService;
    // repository와 service를 함께 사용하면 일관성이 없기 때문에
    // service로만 트랜젝션을 관리하는 것이 좋다

    @PostMapping("/board")
    public ResponseDto<?> save(@RequestBody BoardSaveReqDto boardSaveReqDto) {
        SessionUser principal = (SessionUser) session.getAttribute("principal");
        boardSaveReqDto.setSessionUser(principal);
        boardService.save(boardSaveReqDto); // 서비스에 '단 하나의 객체'만 전달한다 (, 사용 X)
        return new ResponseDto<>(1, "성공", boardSaveReqDto);
    }

    // @GetMapping("/board/{id}")
    // public ResponseDto<?> findById(@PathVariable Long id) {
    // return boardService.findById(id);
    // }

    @GetMapping("/board")
    public List<Board> findAll() {
        return boardService.finAll();
    }

    @PutMapping("/board/{id}")
    public String update(@PathVariable Long id, @RequestBody Board board) {
        boardService.update(id, board);
        return "ok";
    }

    @DeleteMapping("/board/{id}")
    public String deleteById(@PathVariable Long id) {
        boardService.deleteById(id);
        return "ok";
    }
}
