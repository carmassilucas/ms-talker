package chat.talk_to_refugee.ms_talker.infra.config;

import chat.talk_to_refugee.ms_talker.core.port.inbound.CreateTalkerTypeUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerTypeRepositoryAdapterPort;
import chat.talk_to_refugee.ms_talker.core.usecase.CreateTalkerTypeUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {

    @Bean
    public CreateTalkerTypeUseCasePort createTalkerTypeUseCase(TalkerTypeRepositoryAdapterPort repository) {
        return new CreateTalkerTypeUseCase(repository);
    }
}
