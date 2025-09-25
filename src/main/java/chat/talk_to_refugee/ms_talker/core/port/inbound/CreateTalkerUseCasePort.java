package chat.talk_to_refugee.ms_talker.core.port.inbound;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;

public interface CreateTalkerUseCasePort {

    void execute(Talker talker);
}
