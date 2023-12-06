package iuh.fit.duongdinhlong_week6.backend.services;

import iuh.fit.duongdinhlong_week6.backend.models.User;
import iuh.fit.duongdinhlong_week6.backend.repositories.UserRepository;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User getUserById(long id) {
        return userRepository.findById(id).orElse(null);
    }

    public boolean checkLogin(String email) {
        userRepository.findByEmail(email);
        return true;
    }

}