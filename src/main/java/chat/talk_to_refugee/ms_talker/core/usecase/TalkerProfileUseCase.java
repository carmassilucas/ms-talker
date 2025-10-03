package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.TalkerProfileResponse;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerNotFoundException;
import chat.talk_to_refugee.ms_talker.core.port.inbound.TalkerProfileUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;

import java.util.UUID;

public class TalkerProfileUseCase implements TalkerProfileUseCasePort {

    private final TalkerRepositoryAdapterPort repository;

    public TalkerProfileUseCase(TalkerRepositoryAdapterPort repository) {
        this.repository = repository;
    }

    @Override
    public TalkerProfileResponse execute(UUID id) {
        var talker = this.repository.findById(id).orElseThrow(TalkerNotFoundException::new);

        return new TalkerProfileResponse(
                talker.getId(),
                talker.getFullName(),
                talker.getBirthDate(),
                talker.getProfilePhoto(),
                talker.getAboutMe(),
                talker.getLocation(),
                talker.getType(),
                talker.getActive()
        );
    }
}
