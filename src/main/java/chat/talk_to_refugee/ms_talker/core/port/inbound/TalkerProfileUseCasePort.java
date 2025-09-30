package chat.talk_to_refugee.ms_talker.core.port.inbound;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.TalkerProfileResponse;

import java.util.UUID;

public interface TalkerProfileUseCasePort {

    TalkerProfileResponse execute(UUID id);
}
