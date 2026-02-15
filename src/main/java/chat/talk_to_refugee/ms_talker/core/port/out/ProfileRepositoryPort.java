package chat.talk_to_refugee.ms_talker.core.port.out;

import chat.talk_to_refugee.ms_talker.core.domain.Profile;

public interface ProfileRepositoryPort {

    void saveAll(Iterable<Profile> profiles);
}
