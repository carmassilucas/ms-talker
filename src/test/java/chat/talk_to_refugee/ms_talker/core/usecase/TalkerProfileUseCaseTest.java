package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerNotFoundException;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class TalkerProfileUseCaseTest {

    @InjectMocks
    private TalkerProfileUseCase profile;

    @Mock
    private TalkerRepositoryAdapterPort repository;

    @Test
    @DisplayName("Deve recuperar perfil do talker")
    void should_recover_talker_profile() {
        var id = UUID.randomUUID();

        var talker = new Talker();
        talker.setId(id);

        when(this.repository.findById(id)).thenReturn(Optional.of(talker));

        var response = this.profile.execute(id);

        assertNotNull(response);
        assertEquals(id, response.id());
    }

    @Test
    @DisplayName("Deve lançar exceção quando talker não encontrado")
    void should_throw_exception_when_talker_not_found() {
        assertThrows(TalkerNotFoundException.class, () -> this.profile.execute(UUID.randomUUID()));
    }
}