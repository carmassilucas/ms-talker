package chat.talk_to_refugee.ms_talker.core.port.inbound;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.UpdateTalkerRequest;

import java.util.UUID;

public interface UpdateTalkerUseCasePort {

    void execute(UUID id, UpdateTalkerRequest requestBody);
}
