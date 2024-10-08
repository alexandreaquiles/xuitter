package br.com.xuitter.xuitter_api.repositories;

import br.com.xuitter.xuitter_api.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
