package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerNotFoundException;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;
import chat.talk_to_refugee.ms_talker.util.DataProviderUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class ToggleActiveProfileUseCaseTest {

    @InjectMocks
    private ToggleActiveProfileUseCase useCase;

    @Mock
    private TalkerRepositoryAdapterPort repository;

    @Test
    @DisplayName("Deve alternar se perfil do usuário ativo")
    void should_switch_user_profile_is_active() {
        var id = UUID.randomUUID();
        var talker = DataProviderUtil.getSampleDomain();

        when(this.repository.findById(id)).thenReturn(Optional.of(talker));

        this.useCase.execute(id, false);

        verify(this.repository).save(talker);
    }

    @Test
    @DisplayName("Deve não atualizar caso valores iguais")
    void should_not_update_if_same_values() {
        var id = UUID.randomUUID();
        var talker = DataProviderUtil.getSampleDomain();

        when(this.repository.findById(id)).thenReturn(Optional.of(talker));

        this.useCase.execute(id, true);

        verify(this.repository, never()).save(talker);
    }

    @Test
    @DisplayName("Deve lançar exceção quando usuário não encontrado")
    void should_throw_exception_when_user_not_found() {
        var id = UUID.randomUUID();

        when(this.repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(TalkerNotFoundException.class, () -> this.useCase.execute(id, false));

        verify(this.repository, never()).save(any(Talker.class));
    }
}