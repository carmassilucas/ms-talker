package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import chat.talk_to_refugee.ms_talker.core.port.inbound.CreateTalkerTypeUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerTypeRepositoryAdapterPort;

public class CreateTalkerTypeUseCase implements CreateTalkerTypeUseCasePort {

    private final TalkerTypeRepositoryAdapterPort repository;

    public CreateTalkerTypeUseCase(TalkerTypeRepositoryAdapterPort repository) {
        this.repository = repository;
    }

    @Override
    public void execute(TalkerType type) {
        this.repository.save(type);
    }
}
