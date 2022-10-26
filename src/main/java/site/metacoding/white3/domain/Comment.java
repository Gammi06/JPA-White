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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
public class Comment {
    @Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto-increamen
    private Long id;
    @Column(length = 1000) // 데이터의 크기가 1000자인 열
    private String content;

    // User 누가 썼는지
    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    // 조회를 위해서만 필요함 (변수명을 걸어주어야 함)
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY)
    private List<Comment> Comments = new ArrayList<>();

    // Board 어디에 썼는지
    @ManyToOne(fetch = FetchType.LAZY)
    private Board board;

    @Builder
    public Comment(Long id, String content, User user, Board board) {
        this.id = id;
        this.content = content;
        this.user = user;
        this.board = board;
    }

}
