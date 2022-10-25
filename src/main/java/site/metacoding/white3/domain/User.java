package site.metacoding.white3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor // 빈생성자 반드시 만들기 (for Spring)
// @Setter // 나중에 지움 < 변경 불가능한 데이터이기 때문에 세터를 사용하면 안됨 // 지금은 예외
@Getter
@Entity // VO(Entity): 변경 불가능함 || DTO: 전송하는 데이터(변경 가능함)
public class User {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increamen
    private Long id;
    @Column(unique = true)
    private String username;
    private String password;

    @Builder
    // @AllArgsConstructor
    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}
