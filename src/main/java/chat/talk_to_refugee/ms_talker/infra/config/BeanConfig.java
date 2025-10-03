package chat.talk_to_refugee.ms_talker.infra.config;

import chat.talk_to_refugee.ms_talker.core.port.inbound.*;
import chat.talk_to_refugee.ms_talker.core.port.outbound.*;
import chat.talk_to_refugee.ms_talker.core.usecase.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateTalkerTypeUseCasePort createTalkerTypeUseCase(TalkerTypeRepositoryAdapterPort repository) {
        return new CreateTalkerTypeUseCase(repository);
    }

    @Bean
    public CreateTalkerUseCasePort createTalkerUseCase(TalkerRepositoryAdapterPort repository,
                                                       PasswordEncoderAdapterPort encoder) {
        return new CreateTalkerUseCase(repository, encoder);
    }

    @Bean
    public AuthTalkerUseCasePort authTalkerUseCase(TalkerRepositoryAdapterPort repository,
                                                       PasswordEncoderAdapterPort passwordEncoder,
                                                       AuthenticatorAdapterPort oauth2) {
        return new AuthTalkerUseCase(repository, passwordEncoder, oauth2);
    }

    @Bean
    public TalkerProfileUseCasePort talkerProfileUseCase(TalkerRepositoryAdapterPort repository) {
        return new TalkerProfileUseCase(repository);
    }

    @Bean
    public UpdateTalkerPasswordUseCasePort updateTalkerPasswordUseCase(TalkerRepositoryAdapterPort repository,
                                                                       PasswordEncoderAdapterPort passwordEncoder) {
        return new UpdateTalkerPasswordUseCase(repository, passwordEncoder);
    }

    @Bean
    public UpdateTalkerUseCasePort updateTalkerUseCase(TalkerRepositoryAdapterPort repository,
                                                       TalkerMapperAdapterPort mapper) {
        return new UpdateTalkerUseCase(repository, mapper);
    }

    @Bean
    public ToggleActiveProfileUseCasePort toggleActiveProfileUseCase(TalkerRepositoryAdapterPort repository) {
        return new ToggleActiveProfileUseCase(repository);
    }
}
