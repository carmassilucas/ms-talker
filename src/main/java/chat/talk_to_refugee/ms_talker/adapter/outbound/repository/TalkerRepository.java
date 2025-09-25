package chat.talk_to_refugee.ms_talker.adapter.outbound.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface TalkerRepository extends JpaRepository<TalkerEntity, UUID> {

    Optional<TalkerEntity> findByEmail(String email);
}
