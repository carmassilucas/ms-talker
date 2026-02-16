package chat.talk_to_refugee.ms_talker.infra.config;

import chat.talk_to_refugee.ms_talker.core.port.in.CreateProfilesUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.in.CreateTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.out.LoggerPort;
import chat.talk_to_refugee.ms_talker.core.port.out.PasswordEncoderPort;
import chat.talk_to_refugee.ms_talker.core.port.out.ProfileRepositoryPort;
import chat.talk_to_refugee.ms_talker.core.port.out.TalkerRepositoryPort;
import chat.talk_to_refugee.ms_talker.core.usecase.CreateProfilesUseCase;
import chat.talk_to_refugee.ms_talker.core.usecase.CreateTalkerUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateProfilesUseCasePort createProfiles(
            LoggerPort logger,
            ProfileRepositoryPort repository
    ) {
        return new CreateProfilesUseCase(logger, repository);
    }

    @Bean
    public CreateTalkerUseCasePort createTalker(
            LoggerPort logger,
            TalkerRepositoryPort repository,
            PasswordEncoderPort encoder
    ) {
        return new CreateTalkerUseCase(logger, repository, encoder);
    }
}
