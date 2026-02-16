package chat.talk_to_refugee.ms_talker.core.port.out;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;

public interface TalkerRepositoryPort {

    Boolean existsByEmail(String email);

    void save(Talker talker);
}
