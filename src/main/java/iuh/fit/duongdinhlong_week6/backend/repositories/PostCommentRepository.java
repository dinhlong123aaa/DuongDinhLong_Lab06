package iuh.fit.duongdinhlong_week6.backend.repositories;


import java.util.List;

import iuh.fit.duongdinhlong_week6.backend.models.PostComment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface PostCommentRepository extends JpaRepository<PostComment, Long> {
    List<PostComment> findAllByPostId(@Param("postId") Long postId);
}