package chat.talk_to_refugee.ms_talker.core.port.outbound;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.AuthTalkerResponse;

public interface AuthenticatorAdapterPort {

    AuthTalkerResponse auth(String subject);
}
