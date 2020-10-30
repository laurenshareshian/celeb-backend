package net.celebapp.matchmaker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
	public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer>{

	ProfileEntity findProfileByFkEmailId(Integer emailId);

	}



