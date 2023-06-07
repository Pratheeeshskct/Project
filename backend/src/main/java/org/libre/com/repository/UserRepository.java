package org.libre.com.repository;

import java.util.Optional;

import org.libre.com.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel, Integer> {
	public Optional<UserModel> findOneByEmailAndPassword(String email, String password);
	UserModel findByEmail(String email);
}
