package iuh.fit.duongdinhlong_week6.backend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 15)
    private String mobile;
    @Column(name = "last_login")
    private Instant lastLogin;
    @Column(length = 50, name = "last_name")
    private String lastName;
    @Column(columnDefinition = "TINYTEXT")
    private String intro;
    @Column(columnDefinition = "TEXT")
    private String profile;
    @Column(name = "registered_at")
    private Instant registeredAt;
    @Column(name = "password_hash")
    private String passwordHash;
    @Column(length = 50, name = "middle_name")
    private String middleName;
    @Column(length = 50, name = "first_name")
    private String firstName;
    @Column(length = 50)
    private String email;
    @OneToMany(mappedBy = "user")
    private Set<PostComment> postComments;
    @OneToMany(mappedBy = "author")
    private Set<Post> posts;

    public User(Long id) {
        this.id = id;
    }

    public User(String firstName, String middleName, String lastName, String mobile, String email, String passwordHash, Instant registeredAt, Instant lastLogin, String intro, String profile) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.mobile = mobile;
        this.email = email;
        this.passwordHash = passwordHash;
        this.registeredAt = registeredAt;
        this.lastLogin = lastLogin;
        this.intro = intro;
        this.profile = profile;
    }
}