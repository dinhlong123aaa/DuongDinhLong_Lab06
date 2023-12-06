package iuh.fit.duongdinhlong_week6.backend.repositories;


import iuh.fit.duongdinhlong_week6.backend.models.Post;
import iuh.fit.duongdinhlong_week6.backend.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PostRepository extends JpaRepository<Post, Long> {

    Post findPostById(@Param("postId") long postId);
//    List<PostComment> findAllByPostId(@Param("postId") Long postId);


}