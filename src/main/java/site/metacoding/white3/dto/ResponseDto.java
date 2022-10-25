package site.metacoding.white3.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
public class ResponseDto<R> {
    private Integer code;
    private String msg;
    private R data;
}
