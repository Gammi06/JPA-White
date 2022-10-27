package site.metacoding.white3.domain;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository // 얘가 없으면 service가 repository에 의존하기때문에 IoC에 뜰 수 없다
public class BoardRepository {

    // db에서 가져온 데이터를 자바object로 바꿔줌
    private final EntityManager em;

    public Board save(Board board) {
        em.persist(board); // insert 쿼리가 자동으로 돌아감
        return board;
    }

    public Optional<Board> findById(Long id) {
        // 팩토리 패턴
        // Optional : null을 받을 수 있는 타입
        // of Nullable : Optional이라는 박스 안에 값을 담기 때문에 무조건 null체크를 해야 함
        // 제어권이 없어서 tryCatch하기
        try {
            Optional<Board> boardOP = Optional.of(em
                    .createQuery("select b from Board b join fetch b.user u join fetch b.comments c where b.id = :id",
                            Board.class)
                    .setParameter("id", id)
                    .getSingleResult());
            return boardOP;
        } catch (Exception e) {
            return Optional.empty();
        }
    }

    public List<Board> findAll() {
        List<Board> boardsPS = em.createQuery("select b from Board b", Board.class).getResultList();
        return boardsPS;
    }

    public void deleteById(Long id) {
        em.createQuery("delete from Board b where b.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }
}
