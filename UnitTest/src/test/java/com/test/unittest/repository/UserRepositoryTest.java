package com.test.unittest.repository;

import com.test.unittest.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.assertThat;


@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)  // Không thay thế DataSource
public class UserRepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    void testFindByEmail() {
        User user = new User();
        user.setName("John Doe");
        user.setEmail("john.doe@example.com");

        userRepository.save(user);

        User foundUser = userRepository.findByEmail("john.doe@example.com").orElse(null);
        assertThat(foundUser).isNotNull();
        assertThat(foundUser.getName()).isEqualTo("John Doe");
    }
}