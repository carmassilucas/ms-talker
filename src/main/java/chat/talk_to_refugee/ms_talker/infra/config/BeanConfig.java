package chat.talk_to_refugee.ms_talker.infra.config;

import chat.talk_to_refugee.ms_talker.core.port.inbound.AuthTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.inbound.CreateTalkerTypeUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.inbound.CreateTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.inbound.TalkerProfileUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.AuthenticatorAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.PasswordEncoderAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerTypeRepositoryAdapterPort;
import chat.talk_to_refugee.ms_talker.core.usecase.AuthTalkerUseCase;
import chat.talk_to_refugee.ms_talker.core.usecase.CreateTalkerTypeUseCase;
import chat.talk_to_refugee.ms_talker.core.usecase.CreateTalkerUseCase;
import chat.talk_to_refugee.ms_talker.core.usecase.TalkerProfileUseCase;
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
    public AuthTalkerUseCasePort authTalkerUseCasePort(TalkerRepositoryAdapterPort repository,
                                                       PasswordEncoderAdapterPort passwordEncoder,
                                                       AuthenticatorAdapterPort oauth2) {
        return new AuthTalkerUseCase(repository, passwordEncoder, oauth2);
    }

    @Bean
    public TalkerProfileUseCasePort talkerProfileUseCasePort(TalkerRepositoryAdapterPort repository) {
        return new TalkerProfileUseCase(repository);
    }
}
