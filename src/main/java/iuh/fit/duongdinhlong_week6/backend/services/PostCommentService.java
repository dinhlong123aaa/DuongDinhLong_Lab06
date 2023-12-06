package iuh.fit.duongdinhlong_week6.backend.services;

import java.util.List;

import iuh.fit.duongdinhlong_week6.backend.models.PostComment;
import iuh.fit.duongdinhlong_week6.backend.repositories.PostCommentRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostCommentService {

    @Autowired
    private PostCommentRepository postCommentRepository;

    public List<PostComment> findCommentByPost(long postId){
        return postCommentRepository.findAll();
    }

    public List<PostComment> findAllByPostId(@Param("postId") Long postId){
        return postCommentRepository.findAllByPostId(postId);
    }
}