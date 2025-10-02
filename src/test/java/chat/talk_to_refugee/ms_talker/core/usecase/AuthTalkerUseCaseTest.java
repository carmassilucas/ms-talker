package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.AuthTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.AuthTalkerResponse;
import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.exception.PasswordDoesNotMatchesException;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerNotFoundException;
import chat.talk_to_refugee.ms_talker.core.port.outbound.AuthenticatorAdapterPort;
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

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class AuthTalkerUseCaseTest {

    @InjectMocks
    private AuthTalkerUseCase auth;

    @Mock
    private TalkerRepositoryAdapterPort repository;

    @Mock
    private PasswordEncoderAdapterPort passwordEncoder;

    @Mock
    private AuthenticatorAdapterPort authenticator;

    @Test
    @DisplayName("Deve autenticar talker")
    void should_authenticate_talker() {
        var requestBody = new AuthTalkerRequest("john.doe@t2r.com", "john.doe");

        var id = UUID.randomUUID();

        var talker = new Talker();
        talker.setId(id);
        talker.setPassword("john.doe");

        var response = new AuthTalkerResponse("access_token", 300L);

        when(this.repository.findByEmail(requestBody.email())).thenReturn(Optional.of(talker));
        when(this.passwordEncoder.matches(requestBody.password(), talker.getPassword())).thenReturn(true);
        when(this.authenticator.auth(talker.getId().toString())).thenReturn(response);

        assertNotNull(this.auth.execute(requestBody));

        verify(this.repository).findByEmail(requestBody.email());
        verify(this.passwordEncoder).matches(requestBody.password(), talker.getPassword());
        verify(this.authenticator).auth(talker.getId().toString());
    }

    @Test
    @DisplayName("Deve lançar exceção quando talker não encontrado")
    void should_throw_exception_when_talker_not_found() {
        var requestBody = new AuthTalkerRequest("john.doe@t2r.com", "john.doe");

        assertThrows(TalkerNotFoundException.class, () -> this.auth.execute(requestBody));

        verify(this.authenticator, never()).auth(anyString());
    }

    @Test
    @DisplayName("Deve lançar exceção quando senhas não coincidem")
    void should_throw_exception_when_passwords_do_not_match() {
        var requestBody = new AuthTalkerRequest("john.doe@t2r.com", "john.doe");

        var id = UUID.randomUUID();

        var talker = new Talker();
        talker.setId(id);
        talker.setPassword("john.doe");

        when(this.repository.findByEmail(requestBody.email())).thenReturn(Optional.of(talker));
        when(this.passwordEncoder.matches(requestBody.password(), talker.getPassword())).thenReturn(false);

        assertThrows(PasswordDoesNotMatchesException.class, () -> this.auth.execute(requestBody));

        verify(this.authenticator, never()).auth(anyString());
    }
}