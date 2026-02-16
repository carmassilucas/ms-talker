package chat.talk_to_refugee.ms_talker.adapter.out.persistence.talker;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TalkerEntityRepository extends JpaRepository<TalkerEntity, UUID> {

    Boolean existsByEmail(String email);
}
