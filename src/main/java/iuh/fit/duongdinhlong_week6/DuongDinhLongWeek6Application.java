package iuh.fit.duongdinhlong_week6;

import iuh.fit.duongdinhlong_week6.backend.models.Post;
import iuh.fit.duongdinhlong_week6.backend.models.PostComment;
import iuh.fit.duongdinhlong_week6.backend.models.User;
import iuh.fit.duongdinhlong_week6.backend.repositories.PostCommentRepository;
import iuh.fit.duongdinhlong_week6.backend.repositories.PostRepository;
import iuh.fit.duongdinhlong_week6.backend.repositories.UserRepository;
import net.datafaker.Faker;
import org.loremipsum.LoremIpsum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

@SpringBootApplication
public class DuongDinhLongWeek6Application {
    public static void main(String[] args) {
        SpringApplication.run(DuongDinhLongWeek6Application.class, args);
    }

}
