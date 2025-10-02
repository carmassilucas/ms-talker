package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerTypeRepositoryAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateTalkerTypeUseCaseTest {

    @InjectMocks
    private CreateTalkerTypeUseCase create;

    @Mock
    private TalkerTypeRepositoryAdapterPort repository;

    @Test
    @DisplayName("Deve cadastrar tipo")
    void should_register_type() {
        var type = new TalkerType(1L, "administrator");

        this.create.execute(type);

        verify(this.repository).save(type);
    }
}