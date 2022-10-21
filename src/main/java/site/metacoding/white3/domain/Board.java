package site.metacoding.white3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class Board { // 테이블을 자동으로 생성해줌
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    @Column(length = 1000)
    private String content;
}
