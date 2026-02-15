package chat.talk_to_refugee.ms_talker.infra.config;

import chat.talk_to_refugee.ms_talker.core.port.in.CreateProfilesUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.out.LoggerPort;
import chat.talk_to_refugee.ms_talker.core.port.out.ProfileRepositoryPort;
import chat.talk_to_refugee.ms_talker.core.usecase.CreateProfilesUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateProfilesUseCasePort createProfiles(LoggerPort logger,
                                                    ProfileRepositoryPort repository) {
        return new CreateProfilesUseCase(logger, repository);
    }
}
