package chat.talk_to_refugee.ms_talker.core.port.inbound;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.AuthTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.AuthTalkerResponse;

public interface AuthTalkerUseCasePort {

    AuthTalkerResponse execute(AuthTalkerRequest requestBody);
}
