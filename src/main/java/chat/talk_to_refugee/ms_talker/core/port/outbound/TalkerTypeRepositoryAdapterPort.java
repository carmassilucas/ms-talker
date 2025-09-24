package chat.talk_to_refugee.ms_talker.core.port.outbound;

import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;

public interface TalkerTypeRepositoryAdapterPort {

    void save(TalkerType talkerType);
}
