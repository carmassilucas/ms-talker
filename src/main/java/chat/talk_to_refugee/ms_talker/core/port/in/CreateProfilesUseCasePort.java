package chat.talk_to_refugee.ms_talker.core.port.in;

import chat.talk_to_refugee.ms_talker.core.domain.Profile;

public interface CreateProfilesUseCasePort {

    void execute(Iterable<Profile> profiles);
}
