package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.CreateTalkerRequest;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerAlreadyExistsException;
import chat.talk_to_refugee.ms_talker.core.exception.UnderageNotAllowedException;
import chat.talk_to_refugee.ms_talker.core.port.outbound.PasswordEncoderAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CreateTalkerUseCaseTest {

    @InjectMocks
    private CreateTalkerUseCase create;

    @Mock
    private TalkerRepositoryAdapterPort repository;

    @Mock
    private PasswordEncoderAdapterPort passwordEncoder;

    @Test
    @DisplayName("Deve cadastrar talker")
    void must_register_talker() {
        var requestBody = new CreateTalkerRequest(
                "John Doe",
                LocalDate.parse("2000-01-01"),
                TalkerType.Value.ADMINISTRATOR,
                "john.doe@t2r.com",
                "john.doe"
        );
        var talker = requestBody.toDomain();

        when(this.repository.findByEmail(talker.getEmail())).thenReturn(Optional.empty());
        when(this.passwordEncoder.encode(talker.getPassword())).thenReturn(talker.getPassword());

        this.create.execute(talker);

        verify(this.passwordEncoder).encode(talker.getPassword());
        verify(this.repository).save(talker);
    }

    @Test
    @DisplayName("Deve não cadastrar talker quando menor de idade")
    void should_not_register_talker_when_underage() {
        var requestBody = new CreateTalkerRequest(
                "John Doe", LocalDate.now(), TalkerType.Value.ADMINISTRATOR, "john.doe@t2r.com", "john.doe"
        );
        var talker = requestBody.toDomain();

        assertThrows(UnderageNotAllowedException.class, () -> this.create.execute(talker));

        verify(this.passwordEncoder, never()).encode(talker.getPassword());
        verify(this.repository, never()).save(talker);
    }

    @Test
    @DisplayName("Deve não cadastrar talker quando talker já existe")
    void should_not_register_talker_when_talker_already_exists() {
        var requestBody = new CreateTalkerRequest(
                "John Doe",
                LocalDate.parse("2000-01-01"),
                TalkerType.Value.ADMINISTRATOR,
                "john.doe@t2r.com",
                "john.doe"
        );
        var talker = requestBody.toDomain();

        when(this.repository.findByEmail(talker.getEmail())).thenReturn(Optional.of(talker));

        assertThrows(TalkerAlreadyExistsException.class, () -> this.create.execute(talker));

        verify(this.passwordEncoder, never()).encode(talker.getPassword());
        verify(this.repository, never()).save(talker);
    }
}