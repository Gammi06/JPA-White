package site.metacoding.white3.util;

import org.junit.jupiter.api.Test;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

//@NoArgsConstructor // 스프링에서 DB -> rs -> Entity (전략: 디폴트 생성자 호출 후 Setter호출)
//@AllArgsConstructor
@Setter
@Getter
class Product {
    private Integer id;
    private String name;
    private Integer price;
    private Integer qty;
    private String mcp; // 제조사

    @Builder // Arg~들을 사용하지 않고 빌더를 사용함
    public Product(Integer id, String name, Integer price, Integer qty, String mcp) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.qty = qty;
        this.mcp = mcp;
    }
}

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

    public Product toEntity() {
        return Product.builder()
                .name(name)
                .price(price)
                .qty(qty)
                .build();
    }
}

public class MapperTest {

    /*
     * @Test
     * public void 매핑하기() {
     * // 1. Product 객체 생성
     * Product product = new Product();
     * 
     * // 2. 값 넢기
     * product.setId(1);
     * product.setName("바나나");
     * product.setPrice(3000);
     * product.setQty(2);
     * product.setMcp("한성유");
     * 
     * // 3. ProductDto 객체 생성(디폴트)
     * // 4. product -> ProductDto로 옮기기
     * ProductDto productDto = new ProductDto(product);
     * 
     * // 출력
     * System.out.println(productDto.getName());
     * System.out.println(productDto.getPrice());
     * System.out.println(productDto.getQty());
     * }
     */

    @Test
    public void 고급매핑하기() {

        // Product -> ProductDto
        Product product = new Product(1, "바나나", 3000, 1, "한성유");
        ProductDto productDto = new ProductDto(product);

        // ProductDto -> Product
        Product product2 = product.builder().name(productDto.getName()).price(product.getPrice())
                .qty(productDto.getQty()).build();

        System.out.println("ProductDto======");
        System.out.println(productDto.getName());
        System.out.println(productDto.getPrice());
        System.out.println(productDto.getQty());

        System.out.println("Product2=======");
        System.out.println(product2.getName());
        System.out.println(product2.getPrice());
        System.out.println(product2.getQty());
    }
}
