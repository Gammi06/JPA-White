package site.metacoding.white3.util;

import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
class product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
    private String mcp; // 제조사

}

@Getter
@Setter
class productDto {
    private String name;
    private Integer price;
    private Integer qty;
}

public class MapperTest {
    @Test
    public void 매핑하기() {
        // 1. Product 객체 생성
        // 2. 값 넢기
        // 3. ProductDto 객체 생성(디폴트)
        // 4. product -> ProductDto로 옮기기
    }
}
