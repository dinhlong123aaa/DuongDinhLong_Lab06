package iuh.fit.duongdinhlong_week6.backend.repositories;


import iuh.fit.duongdinhlong_week6.backend.models.Post;
import iuh.fit.duongdinhlong_week6.backend.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
//    Optional<User> findByEmailAndPasswordHash(String email, String passwordHash);
//    User findByEmailAndPassword(String email,String passwordHash );
    User findByEmail(String email);
//    User findUserByPosts(Post post);
    User findUserById(long id);

}