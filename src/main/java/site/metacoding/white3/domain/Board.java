package site.metacoding.white3.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

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

    // 조회를 위해서만 필요함 (변수명을 걸어주어야 함)
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<Comment> Comments = new ArrayList<>();

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
