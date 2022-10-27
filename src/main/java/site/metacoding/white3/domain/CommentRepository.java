package site.metacoding.white3.domain;

import java.util.Optional;

import javax.persistence.EntityManager;

import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j // 로그 사용할 때
@RequiredArgsConstructor
@Repository // 얘가 없으면 service가 repository에 의존하기때문에 IoC에 뜰 수 없다
public class CommentRepository {

    private final EntityManager em;

    public Comment save(Comment comment) {
        em.persist(comment); // insert 쿼리가 자동으로 돌아감
        return comment;
    }

    public void deleteById(Long id) {
        em.createQuery("delete from Comment c where c.id = :id")
                .setParameter("id", id)
                .executeUpdate();
    }

    public Optional<Comment> findById(Long id) {
        try {
            Optional<Comment> commentOP = Optional.of(em
                    .createQuery("select c from Comment c where c.id = :id", Comment.class)
                    .setParameter("id", id)
                    .getSingleResult());
            return commentOP;
        } catch (Exception e) {
            return Optional.empty();
        }
    }
}
