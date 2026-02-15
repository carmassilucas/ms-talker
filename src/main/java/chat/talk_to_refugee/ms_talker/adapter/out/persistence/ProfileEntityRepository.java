package chat.talk_to_refugee.ms_talker.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileEntityRepository extends JpaRepository<ProfileEntity, Long> {
}
