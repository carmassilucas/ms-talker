package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.core.domain.Profile.Name;
import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.exception.AdminProfileNotAllowedException;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerAlreadyExistsException;
import chat.talk_to_refugee.ms_talker.core.exception.UnderageNotAllowedException;
import chat.talk_to_refugee.ms_talker.core.port.in.CreateTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.out.LoggerPort;
import chat.talk_to_refugee.ms_talker.core.port.out.PasswordEncoderPort;
import chat.talk_to_refugee.ms_talker.core.port.out.TalkerRepositoryPort;

import java.time.LocalDate;

public class CreateTalkerUseCase implements CreateTalkerUseCasePort {

    private final LoggerPort logger;
    private final TalkerRepositoryPort repository;
    private final PasswordEncoderPort encoder;

    public CreateTalkerUseCase(LoggerPort logger, TalkerRepositoryPort repository, PasswordEncoderPort encoder) {
        this.logger = logger;
        this.repository = repository;
        this.encoder = encoder;
    }

    @Override
    public void execute(Talker talker) {
        logger.info(this.getClass(), "Creating talker with e-mail ".concat(talker.getEmail()));

        var eighteenYearsAgo = LocalDate.now().minusYears(18);
        if (talker.getBirthDate().isAfter(eighteenYearsAgo)) {
            logger.warn(this.getClass(), "Registration is not permitted for minors under 18 years of age");
            throw new UnderageNotAllowedException();
        }

        var adminProfile = Name.ADMIN.get();
        if (adminProfile.equals(talker.getProfile())) {
            logger.warn(this.getClass(), "Registration of administrator users is not allowed");
            throw new AdminProfileNotAllowedException();
        }

        if (this.repository.existsByEmail(talker.getEmail())) {
            logger.warn(this.getClass(), "The e-mail address is already in use");
            throw new TalkerAlreadyExistsException();
        }

        var encodedPassword = this.encoder.encode(talker.getPassword());
        talker.setPassword(encodedPassword);

        this.repository.save(talker);

        logger.info(this.getClass(), "Talker creation successfully");
    }
}
