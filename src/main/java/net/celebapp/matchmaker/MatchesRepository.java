package net.celebapp.matchmaker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
	public interface MatchesRepository extends JpaRepository<MatchesEntity, Integer>{

	@Modifying
	@Transactional
	@Query(value = "INSERT INTO matches (fk_profile_id, fk_dream_profile_id, message_to_dream_profile) " +
			"VALUES (?1, ?2, ?3);", nativeQuery = true)
	void addMatch(Integer profileId, Integer dreamProfileId, String message);

	@Modifying
	@Transactional
	@Query(value = "DELETE FROM matches WHERE fk_profile_id=?1 AND fk_dream_profile_id=?2", nativeQuery = true)
	void unlike(Integer profileId, Integer dreamProfileId);

	@Modifying
	@Transactional
	@Query(value = "UPDATE matches SET message_to_dream_profile = ?3 WHERE fk_profile_id = ?1 and fk_dream_profile_id = ?2", nativeQuery = true)
	void sendMessage(Integer profileId, Integer dreamProfileId, String messageToDreamProfile);

	MatchesEntity findByFkProfileIdAndFkDreamProfileId(Integer profileId, Integer dreamProfileId);

	}



