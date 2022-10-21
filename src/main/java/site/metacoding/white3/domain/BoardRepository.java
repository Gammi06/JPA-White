package site.metacoding.white3.domain;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
// @Repository //얘가 없으면 service가 repository에 의존하기때문에 IoC에 뜰 수 없다
public class BoardRepository {

    // db에서 가져온 데이터를 자바object로 바꿔줌
    private final EntityManager em;

    public void save(Board board) {
        em.persist(board); // insert 쿼리가 자동으로 돌아감
    }
}
