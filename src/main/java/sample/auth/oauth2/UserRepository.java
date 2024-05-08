package sample.auth.oauth2;

import org.springframework.data.jpa.repository.JpaRepository;
import sample.auth.oauth2.user.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);
}
