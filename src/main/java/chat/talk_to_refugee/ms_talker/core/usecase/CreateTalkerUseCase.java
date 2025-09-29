package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerAlreadyExistsException;
import chat.talk_to_refugee.ms_talker.core.exception.UnderageNotAllowedException;
import chat.talk_to_refugee.ms_talker.core.port.inbound.CreateTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.PasswordEncoderAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;

import java.time.LocalDate;

public class CreateTalkerUseCase implements CreateTalkerUseCasePort {

    private final TalkerRepositoryAdapterPort repository;
    private final PasswordEncoderAdapterPort encoder;

    public CreateTalkerUseCase(TalkerRepositoryAdapterPort repository, PasswordEncoderAdapterPort encoder) {
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void execute(Talker talker) {
        if (talker.getBirthDate().isAfter(LocalDate.now().minusYears(18))) {
            throw new UnderageNotAllowedException();
        }

        if (this.repository.findByEmail(talker.getEmail()).isPresent()) {
            throw new TalkerAlreadyExistsException();
        }

        talker.setPassword(this.encoder.encode(talker.getPassword()));
        this.repository.save(talker);
    }
}
