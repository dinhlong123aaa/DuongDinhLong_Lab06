package iuh.fit.duongdinhlong_week6.backend.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "post")
@Getter
@Setter
@NoArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;

    @Column(length = 75, nullable = false)
    private String title;
    @Column(length = 100)
    private String metaTitle;
    @Lob
    @Column(columnDefinition = "text")
    private String summary;
    @Column(name = "published", nullable = false)
    private boolean published;
    @Column(name = "createdAt", nullable = false)
    private Instant createdAt;
    @Column(name = "updatedAt")
    private Instant updatedAt;
    @Column(name = "publishedAt")
    private Instant publishedAt;
    @Lob
    @Column(name = "content", columnDefinition = "text")
    private String content;

    @ManyToOne
    @JoinColumn(name = "authorId")
    private User author;

    @ManyToOne
    @JoinColumn(name = "parentId")
    private Post parent;

    @OneToMany(mappedBy = "parent")
    private Set<Post> posts = new LinkedHashSet<>();

    @OneToMany(mappedBy = "post")
    private Set<PostComment> postComments = new LinkedHashSet<>();
    public Post(User author, String title, String metaTitle, String summary, boolean published,
                Instant createdAt, Instant updatedAt, Instant publishedAt, String content) {
        this.author = author;
        this.title = title;
        this.metaTitle = metaTitle;
        this.summary = summary;
        this.published = published;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
        this.publishedAt = publishedAt;
        this.content = content;
    }

}
