package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerAlreadyExistsException;
import chat.talk_to_refugee.ms_talker.core.exception.UnderageNotAllowedException;
import chat.talk_to_refugee.ms_talker.core.port.inbound.CreateTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;

import java.time.LocalDate;

public class CreateTalkerUseCase implements CreateTalkerUseCasePort {

    private final TalkerRepositoryAdapterPort repository;

    public CreateTalkerUseCase(TalkerRepositoryAdapterPort repository) {
        this.repository = repository;
    }

    @Override
    public void execute(Talker talker) {
        if (talker.getBirthDate().isAfter(LocalDate.now().minusYears(18))) {
            throw new UnderageNotAllowedException();
        }

        if (this.repository.findByEmail(talker.getEmail()).isPresent()) {
            throw new TalkerAlreadyExistsException();
        }

        this.repository.save(talker);
    }
}
