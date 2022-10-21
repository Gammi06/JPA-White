package site.metacoding.white3.web;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.domain.Board;
import site.metacoding.white3.service.BoardService;

@RestController
@RequiredArgsConstructor
public class BoardApiController {
    private final BoardService boardService;
    // repository와 service를 함께 사용하면 일관성이 없기 때문에
    // service로만 트랜젝션을 관리하는 것이 좋다

    @GetMapping("/board/{id}")
    public Board findById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @GetMapping("/board")
    public List<Board> findAll() {
        return boardService.finAll();
    }

    // JSON으로 받을거니까 request body를 붙인다
    @PostMapping("/board")
    public String save(@RequestBody Board board) {
        boardService.save(board);
        return "ok";
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
