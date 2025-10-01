package chat.talk_to_refugee.ms_talker.core.port.inbound;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.UpdateTalkerPasswordRequest;

import java.util.UUID;

public interface UpdateTalkerPasswordUseCasePort {

    void execute(UUID id, UpdateTalkerPasswordRequest requestBody);
}
