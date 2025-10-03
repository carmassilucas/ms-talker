package chat.talk_to_refugee.ms_talker.adapter.outbound.mapper;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UpdateTalkerAdapterTest {

    @InjectMocks
    private UpdateTalkerAdapter adapter;

    @Mock
    private UpdateTalkerMapper mapper;

    @Test
    @DisplayName("Deve delegar a atualização ao mapper")
    void should_delegate_update_to_mapper() {
        var source = mock(Talker.class);
        var target = mock(Talker.class);

        adapter.update(source, target);

        verify(mapper).update(source, target);
        verifyNoMoreInteractions(mapper);
    }
}