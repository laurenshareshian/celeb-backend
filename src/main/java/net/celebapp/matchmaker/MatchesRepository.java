package net.celebapp.matchmaker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

    @Repository
	public interface MatchesRepository extends JpaRepository<MatchesEntity, Integer>{

	}



