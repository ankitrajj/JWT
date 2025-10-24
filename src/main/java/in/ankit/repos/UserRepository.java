package in.ankit.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import in.ankit.models.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Integer>{

	public Optional<UserEntity> findByEmail(String email);

}
