package chat.talk_to_refugee.ms_talker.core.port.inbound;

import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;

public interface CreateTalkerTypeUseCasePort {

    void execute(TalkerType type);
}
