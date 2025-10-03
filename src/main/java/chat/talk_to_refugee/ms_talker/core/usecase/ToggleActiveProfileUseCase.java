package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.core.exception.TalkerNotFoundException;
import chat.talk_to_refugee.ms_talker.core.port.inbound.ToggleActiveProfileUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;

import java.util.UUID;

public class ToggleActiveProfileUseCase implements ToggleActiveProfileUseCasePort {

    private final TalkerRepositoryAdapterPort repository;

    public ToggleActiveProfileUseCase(TalkerRepositoryAdapterPort repository) {
        this.repository = repository;
    }

    @Override
    public void execute(UUID id, Boolean active) {
        var talker = this.repository.findById(id).orElseThrow(TalkerNotFoundException::new);

        if (!talker.getActive().equals(active)) {
            talker.setActive(active);
            this.repository.save(talker);
        }
    }
}
