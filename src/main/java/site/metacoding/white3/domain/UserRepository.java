package site.metacoding.white3.domain;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 사용할 때
@RequiredArgsConstructor
@Repository // 얘가 없으면 service가 repository에 의존하기때문에 IoC에 뜰 수 없다
public class UserRepository {

    // db에서 가져온 데이터를 자바object로 바꿔줌
    private final EntityManager em;

    public User save(User user) {
        log.debug("happyQuaka: " + user.getId());
        em.persist(user); // insert 쿼리가 자동으로 돌아감
        log.debug("happyQuaka: " + user.getId());
        return user;
    }

    public User findByUsername(String username) {
        return em.createQuery("select u from User u where u.username = :username", User.class)
                .setParameter("username", username)
                .getSingleResult();
    }

    public User findById(Long id) {
        return em.createQuery("select u from User u where u.id = :id", User.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
