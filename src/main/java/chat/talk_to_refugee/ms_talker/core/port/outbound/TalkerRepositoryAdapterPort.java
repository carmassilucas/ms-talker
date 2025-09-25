package chat.talk_to_refugee.ms_talker.core.port.outbound;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;

import java.util.Optional;

public interface TalkerRepositoryAdapterPort {

    Optional<Talker> findByEmail(String email);
    void save(Talker talker);
}
