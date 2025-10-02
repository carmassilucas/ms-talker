package chat.talk_to_refugee.ms_talker.core.usecase;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.UpdateTalkerRequest;
import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerLocation;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import chat.talk_to_refugee.ms_talker.core.exception.TalkerNotFoundException;
import chat.talk_to_refugee.ms_talker.core.exception.UnderageNotAllowedException;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerMapperAdapterPort;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateTalkerUseCaseTest {

    @InjectMocks
    private UpdateTalkerUseCase useCase;

    @Mock
    private TalkerRepositoryAdapterPort repository;

    @Mock
    private TalkerMapperAdapterPort mapper;

    @Test
    @DisplayName("Deve atualizar informações do talker")
    void shoud_update_talker_info() {
        var id = UUID.randomUUID();
        var requestBody = new UpdateTalkerRequest(
                "fullName",
                LocalDate.now().minusYears(18),
                "aboutMe",
                new TalkerLocation("state", "city"),
                TalkerType.Value.ADMINISTRATOR.get()
        );

        var talker = new Talker();
        talker.setId(id);

        when(this.repository.findById(id)).thenReturn(Optional.of(talker));

        this.useCase.execute(id, requestBody);

        verify(this.mapper).update(requestBody.toDomain(), talker);
        verify(this.repository).save(talker);
    }

    @Test
    @DisplayName("Deve lançar exceção quando menor de idade")
    void should_throw_exception_when_underage() {
        var id = UUID.randomUUID();
        var requestBody = new UpdateTalkerRequest(
                "fullName",
                LocalDate.now(),
                "aboutMe",
                new TalkerLocation("state", "city"),
                TalkerType.Value.ADMINISTRATOR.get()
        );

        assertThrows(UnderageNotAllowedException.class, () -> this.useCase.execute(id, requestBody));

        verify(this.mapper, never()).update(eq(requestBody.toDomain()), any(Talker.class));
        verify(this.repository, never()).save(any(Talker.class));
    }

    @Test
    @DisplayName("Deve lançar exceção quando talker não encontrado")
    void should_throw_exception_when_talker_not_found() {
        var id = UUID.randomUUID();
        var requestBody = new UpdateTalkerRequest(
                "fullName",
                LocalDate.now().minusYears(18),
                "aboutMe",
                new TalkerLocation("state", "city"),
                TalkerType.Value.ADMINISTRATOR.get()
        );

        when(this.repository.findById(id)).thenReturn(Optional.empty());

        assertThrows(TalkerNotFoundException.class, () -> this.useCase.execute(id, requestBody));

        verify(this.mapper, never()).update(eq(requestBody.toDomain()), any(Talker.class));
        verify(this.repository, never()).save(any(Talker.class));
    }
}