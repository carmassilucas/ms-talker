package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.UpdateTalkerRequest;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerNotFoundException;
import chat.talk_to_refugee.ms_talker.core.exception.UnderageNotAllowedException;
import chat.talk_to_refugee.ms_talker.core.port.inbound.UpdateTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerMapperAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;

import java.time.LocalDate;
import java.util.UUID;

public class UpdateTalkerUseCase implements UpdateTalkerUseCasePort {

    private final TalkerRepositoryAdapterPort repository;
    private final TalkerMapperAdapterPort mapper;

    public UpdateTalkerUseCase(TalkerRepositoryAdapterPort repository, TalkerMapperAdapterPort mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public void execute(UUID id, UpdateTalkerRequest requestBody) {
        if (requestBody.birthDate() != null &&
                requestBody.birthDate().isAfter(LocalDate.now().minusYears(18))) {
            throw new UnderageNotAllowedException();
        }

        var talker = this.repository.findById(id)
                .orElseThrow(TalkerNotFoundException::new);

        this.mapper.update(requestBody.toDomain(), talker);

        this.repository.save(talker);
    }
}
