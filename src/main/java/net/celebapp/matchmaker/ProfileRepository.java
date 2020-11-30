package net.celebapp.matchmaker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
	public interface ProfileRepository extends JpaRepository<ProfileEntity, Integer>{

	ProfileEntity findProfileByFkEmailId(Integer emailId);

	@Query(value = "SELECT * FROM matches INNER JOIN profile ON fk_profile_id = profile_id WHERE fk_dream_profile_id = ?1", nativeQuery = true)
	List<ProfileEntity> findAdmirersById(Integer profileId);

	@Query(value = "SELECT p.profile_id, p.first_name,  p.last_name,  p.age, p.gender, p.celeb_status, p.bio, p.pic_url, p.fk_email_id, loves.message_to_dream_profile " +
			"FROM profile as p INNER JOIN " +
			"(SELECT * FROM matches WHERE fk_profile_id = ANY " +
			"(SELECT fk_dream_profile_id FROM matches WHERE fk_profile_id = ?1) " +
			"AND fk_dream_profile_id = ?1) AS loves " +
			"ON profile_id = loves.fk_profile_id;", nativeQuery = true)
	List<ProfileEntity> findMatchesById(Integer profileId);

	@Query(value = "SELECT * from profile " +
			"WHERE gender = (SELECT gender FROM preferences WHERE fk_profile_id = ?1) " +
			"AND age BETWEEN (SELECT age_min FROM preferences WHERE fk_profile_id = ?1) " +
			"AND (SELECT age_max FROM preferences WHERE fk_profile_id = ?1)", nativeQuery = true)
	List<ProfileEntity> findCompatiblesById(Integer profileId);
}



