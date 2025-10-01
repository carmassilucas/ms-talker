package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.UpdateTalkerPasswordRequest;
import chat.talk_to_refugee.ms_talker.core.exception.PasswordDoesNotMatchesException;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerNotFoundException;
import chat.talk_to_refugee.ms_talker.core.port.inbound.UpdateTalkerPasswordUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.PasswordEncoderAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;

import java.util.UUID;

public class UpdateTalkerPasswordUseCase implements UpdateTalkerPasswordUseCasePort {

    private final TalkerRepositoryAdapterPort repository;
    private final PasswordEncoderAdapterPort passwordEncoder;

    public UpdateTalkerPasswordUseCase(TalkerRepositoryAdapterPort repository,
                                       PasswordEncoderAdapterPort passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void execute(UUID id, UpdateTalkerPasswordRequest requestBody) {
        var talker = this.repository.findById(id).orElseThrow(TalkerNotFoundException::new);

        if (!this.passwordEncoder.matches(requestBody.currentPassword(), talker.getPassword())) {
            throw new PasswordDoesNotMatchesException();
        }

        var password = this.passwordEncoder.encode(requestBody.newPassword());
        talker.setPassword(password);

        this.repository.save(talker);
    }
}
