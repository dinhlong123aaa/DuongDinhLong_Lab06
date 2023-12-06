package iuh.fit.duongdinhlong_week6.frontend.controllers;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import iuh.fit.duongdinhlong_week6.backend.models.Post;
import iuh.fit.duongdinhlong_week6.backend.models.User;
import iuh.fit.duongdinhlong_week6.backend.repositories.PostRepository;
import iuh.fit.duongdinhlong_week6.backend.repositories.UserRepository;
import iuh.fit.duongdinhlong_week6.backend.services.PostService;
import iuh.fit.duongdinhlong_week6.backend.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private PostService postService;
    @Autowired
    private UserService userService;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/blog")
    public String showBlogListPaging(Model model,
                                     @RequestParam("page") Optional<Integer> page,
                                     @RequestParam("size") Optional<Integer> size) {
        int currentPage = page.orElse(1);
        int pageSize = size.orElse(4);

        Page<Post> postPage = postService.findPaginated(currentPage - 1,
                pageSize, "title", "asc");

        model.addAttribute("postPage", postPage);

        int totalPages = postPage.getTotalPages();
        if (totalPages > 0) {
            List<Integer> pageNumbers = IntStream.rangeClosed(1, totalPages)
                    .boxed()
                    .collect(Collectors.toList());
            model.addAttribute("pageNumbers", pageNumbers);
        }
        return "blog";
    }

    @GetMapping("/show-add-form")
    public String add(Model model) {
        Post post = new Post();
        model.addAttribute("post", post);
        return "add-form-post";
    }

    @PostMapping("/addPost")
    public String addPost(
            @ModelAttribute("post") Post post,
            BindingResult result, Model model) {
        Post post1 = new Post(new User(3l), post.getTitle(), post.getMetaTitle(), post.getSummary(),
                post.isPublished(), Instant.now(), Instant.now(), Instant.now(), post.getContent());

        postRepository.save(post1);
        return "redirect:/blog";
    }

}