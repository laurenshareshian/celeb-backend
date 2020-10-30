package net.celebapp.matchmaker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
	public interface LoginRepository extends JpaRepository<LoginEntity, Integer>{

//		@Query("SELECT l FROM login l WHERE l.email = ?1 and l.password = ?2")
		List<LoginEntity> findLoginByEmailAndPassword(String email, String password);
	}



