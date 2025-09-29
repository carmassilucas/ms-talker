package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.AuthTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.AuthTalkerResponse;
import chat.talk_to_refugee.ms_talker.core.exception.PasswordDoesNotMatchesException;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerNotFoundException;
import chat.talk_to_refugee.ms_talker.core.port.inbound.AuthTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.PasswordEncoderAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.AuthenticatorAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;

public class AuthTalkerUseCase implements AuthTalkerUseCasePort {

    private final TalkerRepositoryAdapterPort repository;
    private final PasswordEncoderAdapterPort passwordEncoder;
    private final AuthenticatorAdapterPort authenticator;

    public AuthTalkerUseCase(TalkerRepositoryAdapterPort repository,
                             PasswordEncoderAdapterPort passwordEncoder, 
                             AuthenticatorAdapterPort authenticator) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
        this.authenticator = authenticator;
    }

    @Override
    public AuthTalkerResponse execute(AuthTalkerRequest requestBody) {
        var entity = this.repository.findByEmail(requestBody.email())
                .orElseThrow(TalkerNotFoundException::new);

        if (!this.passwordEncoder.matches(requestBody.password(), entity.getPassword())) {
            throw new PasswordDoesNotMatchesException();
        }

        return this.authenticator.auth(entity.getId().toString());
    }
}
