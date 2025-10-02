package chat.talk_to_refugee.ms_talker.core.port.outbound;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;

public interface TalkerMapperAdapterPort {

    void update(Talker source, Talker target);
}
