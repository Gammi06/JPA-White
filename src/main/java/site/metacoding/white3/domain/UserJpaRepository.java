package site.metacoding.white3.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserJpaRepository extends JpaRepository<User, Long> {

    @Query(value = "select u from User u where u.username = :username")
    User findByUsername(@Param("username") String username);
    // findBy(필드명) 하면 쿼리가 알아서 만들어진다. <완죤 짱이네!!!
    // jpa 네임드 쿼리 << 하지만 직접 쓰는게 많이 느니까 직접 쓰는게 좋음
}