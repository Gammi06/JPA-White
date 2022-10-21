package site.metacoding.white3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity // 테이블로 생성
public class Board {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increamen
    private Long id;
    private String title;
    @Column(length = 1000) // 데이터의 크기가 1000자인 열
    private String content;
}
