package site.metacoding.white3.util;

import org.junit.jupiter.api.Test;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
    private String mcp; // 제조사

}

@NoArgsConstructor
@Getter
@Setter
class ProductDto {
    private String name;
    private Integer price;
    private Integer qty;

    public ProductDto(Product product) {
        this.name = product.getName();
        this.price = product.getPrice();
        this.qty = product.getQty();
    }
}

public class MapperTest {
    @Test
    public void 매핑하기() {
        // 1. Product 객체 생성
        Product product = new Product();

        // 2. 값 넢기
        product.setId(1);
        product.setName("바나나");
        product.setPrice(3000);
        product.setQty(2);
        product.setMcp("한성유");

        // 3. ProductDto 객체 생성(디폴트)
        // 4. product -> ProductDto로 옮기기
        ProductDto productDto = new ProductDto(product);

        // 출력
        System.out.println(productDto.getName());
        System.out.println(productDto.getPrice());
        System.out.println(productDto.getQty());
    }
}
