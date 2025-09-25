package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.AuthTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.AuthTalkerResponse;
import chat.talk_to_refugee.ms_talker.core.port.inbound.AuthTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.PasswordEncoderAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.AuthenticatorAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;

public class AuthTalkerUseCase implements AuthTalkerUseCasePort {

    private final TalkerRepositoryAdapterPort repository;
    private final PasswordEncoderAdapterPort passwordEncoder;
    private final AuthenticatorAdapterPort oauth2;

    public AuthTalkerUseCase(TalkerRepositoryAdapterPort repository,
                             PasswordEncoderAdapterPort passwordEncoder, 
                             AuthenticatorAdapterPort oauth2) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.oauth2 = oauth2;
    }

    @Override
    public AuthTalkerResponse execute(AuthTalkerRequest requestBody) {
        var entity = this.repository.findByEmail(requestBody.email())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email"));

        if (!this.passwordEncoder.matches(requestBody.password(), entity.getPassword())) {
            throw new IllegalArgumentException("Invalid password");
        }

        return this.oauth2.auth(entity.getId().toString());
    }
}
