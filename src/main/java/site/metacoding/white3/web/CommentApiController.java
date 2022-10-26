package site.metacoding.white3.web;

import javax.servlet.http.HttpSession;

import org.hibernate.query.criteria.internal.expression.ConcatExpression;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import site.metacoding.white3.dto.ResponseDto;
import site.metacoding.white3.dto.SessionUser;
import site.metacoding.white3.dto.CommentReqDto.CommentSaveReqDto;
import site.metacoding.white3.service.CommentService;

@RequiredArgsConstructor
@RestController
public class CommentApiController {

    private final CommentService commentService;
    private final HttpSession session;

    @PostMapping("/comment")
    public ResponseDto<?> save(@RequestBody CommentSaveReqDto commentSaveReqDto) {
        SessionUser sessionUser = (SessionUser) session.getAttribute("sessionUser");
        commentSaveReqDto.setSessionUser(sessionUser);
        return new ResponseDto<>(1, "성공", commentService.save(commentSaveReqDto));
    }
}
