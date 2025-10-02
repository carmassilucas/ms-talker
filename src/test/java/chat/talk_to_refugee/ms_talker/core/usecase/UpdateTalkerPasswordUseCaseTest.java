package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.UpdateTalkerPasswordRequest;
import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.exception.PasswordDoesNotMatchesException;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerNotFoundException;
import chat.talk_to_refugee.ms_talker.core.port.outbound.PasswordEncoderAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;
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
class UpdateTalkerPasswordUseCaseTest {

    @InjectMocks
    private UpdateTalkerPasswordUseCase usecase;

    @Mock
    private TalkerRepositoryAdapterPort repository;

    @Mock
    private PasswordEncoderAdapterPort encoder;

    @Test
    @DisplayName("Deve atualizar a senha do talker")
    void should_update_talker_password() {
        var id = UUID.randomUUID();

        var requestBody = new UpdateTalkerPasswordRequest("currentPassword", "newPassword");

        var talker = new Talker();
        talker.setPassword("currentPassword");
        talker.setId(id);

        when(this.repository.findById(id)).thenReturn(Optional.of(talker));
        when(this.encoder.matches(requestBody.currentPassword(), talker.getPassword())).thenReturn(true);
        when(this.encoder.encode(requestBody.newPassword())).thenReturn("newPassword");

        this.usecase.execute(id, requestBody);

        verify(this.repository).save(talker);
    }

    @Test
    @DisplayName("Deve lançar exceção quando talker não encontrado")
    void should_throw_exception_when_talker_not_found() {
        var id = UUID.randomUUID();
        var requestBody = new UpdateTalkerPasswordRequest("currentPassword", "newPassword");

        when(this.repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(TalkerNotFoundException.class, () -> this.usecase.execute(id, requestBody));

        verify(this.repository, never()).save(any(Talker.class));
    }

    @Test
    @DisplayName("Deve lançar exceção quando senhas não coincidem")
    void should_throw_exception_when_password_does_not_match() {
        var id = UUID.randomUUID();

        var requestBody = new UpdateTalkerPasswordRequest("incorrectPassword", "newPassword");

        var talker = new Talker();
        talker.setPassword("currentPassword");
        talker.setId(id);

        when(this.repository.findById(id)).thenReturn(Optional.of(talker));
        when(this.encoder.matches(requestBody.currentPassword(), talker.getPassword())).thenReturn(false);

        assertThrows(PasswordDoesNotMatchesException.class, () -> this.usecase.execute(id, requestBody));

        verify(this.repository, never()).save(any(Talker.class));
    }
}