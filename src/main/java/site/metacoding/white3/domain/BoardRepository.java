package site.metacoding.white3.domain;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository // 얘가 없으면 service가 repository에 의존하기때문에 IoC에 뜰 수 없다
public class BoardRepository {

    // db에서 가져온 데이터를 자바object로 바꿔줌
    private final EntityManager em;

    public void save(Board board) {
        em.persist(board); // insert 쿼리가 자동으로 돌아감
    }

    public Board findById(Long id) {
        // 네이티브는 복잡한 거, 크리에이트는 간단한 거
        // Board < 자바의 엔티티
        Board boardPS = em.createQuery("select b from Board b where b.id = :id", Board.class)
                .setParameter("id", id).getSingleResult();
        // 맵핑, 리턴값
        return findById(id);
    }

    public List<Board> findAll() {
        List<Board> boardsPS = em.createQuery("select b from Board b", Board.class).getResultList();
        return boardsPS;
    }

    public void deleteById(Long id) {
        em.createQuery("delete from Board b where b.id = :id").setParameter("id", id).executeUpdate();
    }
}
