package iuh.fit.duongdinhlong_week6.backend.services;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import iuh.fit.duongdinhlong_week6.backend.models.Post;
import iuh.fit.duongdinhlong_week6.backend.repositories.PostRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class PostService {

    @Autowired
    private PostRepository postRepository;

    public void addPost(Post post) {
        try {
            postRepository.save(post);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public List<Post> getAllPost() {
        return postRepository.findAll();
    }

    public Optional<Post> findByID(long id){
        return  postRepository.findById(id);
    }

    public Page<Post> findPaginated(int pageNo, int pageSize, String sortBy, String sortDirection) {
        Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);
        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
        return postRepository.findAll(pageable);//findFirst.../findTop...
    }

    public Post findPostById(@Param("postId") long postId){
        return postRepository.findPostById(postId);
    }

}