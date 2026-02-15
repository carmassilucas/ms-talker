package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.core.port.in.CreateProfilesUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.out.LoggerPort;
import chat.talk_to_refugee.ms_talker.core.port.out.ProfileRepositoryPort;
import chat.talk_to_refugee.ms_talker.core.domain.Profile;

public class CreateProfilesUseCase implements CreateProfilesUseCasePort {

    private final LoggerPort logger;

    private final ProfileRepositoryPort repository;

    public CreateProfilesUseCase(LoggerPort logger, ProfileRepositoryPort repository) {
        this.logger = logger;
        this.repository = repository;
    }

    @Override
    public void execute(Iterable<Profile> profiles) {
        logger.info(this.getClass(), "Ensuring that talker profiles are registered");
        this.repository.saveAll(profiles);
    }
}
