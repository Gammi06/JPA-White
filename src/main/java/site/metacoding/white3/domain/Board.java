package site.metacoding.white3.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
@Entity // 테이블로 생성
public class Board {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increamen
    private Long id;
    private String title;
    @Column(length = 1000) // 데이터의 크기가 1000자인 열
    private String content;

    // FK가 만들어짐 user_id
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @Builder
    public Board(Long id, String title, String content, User user) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
