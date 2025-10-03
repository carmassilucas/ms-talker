package chat.talk_to_refugee.ms_talker.adapter.outbound.repository;

import chat.talk_to_refugee.ms_talker.util.DataProviderUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TalkerRepositoryAdapterTest {

    @Nested
    class SaveTest {
        @InjectMocks
        private TalkerRepositoryAdapter adapter;

        @Mock
        private TalkerRepository repository;

        @Test
        @DisplayName("Deve salvar talker")
        void should_save_talker() {
            var talker = DataProviderUtil.getSampleDomain();
            this.adapter.save(talker);

            var captor = ArgumentCaptor.forClass(TalkerEntity.class);
            verify(this.repository).save(captor.capture());

            var entity = captor.getValue();

            assertThat(entity).usingRecursiveComparison().isEqualTo(new TalkerEntity(talker));
        }
    }

    @Nested
    class FindByIdTest {
        @InjectMocks
        private TalkerRepositoryAdapter adapter;

        @Mock
        private TalkerRepository repository;

        @Test
        @DisplayName("Deve retornar talker ao encontrar por id")
        void should_return_talker_when_found_by_id() {
            var id = UUID.randomUUID();

            var expected = DataProviderUtil.getSampleDomain();
            expected.setId(id);

            var entity = mock(TalkerEntity.class);

            when(this.repository.findById(id)).thenReturn(Optional.of(entity));
            when(entity.toDomain()).thenReturn(expected);

            var talker = this.adapter.findById(id);

            assertNotNull(talker);
            assertTrue(talker.isPresent());
            assertEquals(expected, talker.get());

            verify(this.repository).findById(id);
            verify(entity).toDomain();
        }


        @Test
        @DisplayName("Deve retornar empty quando talker não encontrado pelo id")
        void should_return_empty_when_talker_not_found_by_id() {
            var id = UUID.randomUUID();
            when(repository.findById(id)).thenReturn(Optional.empty());

            var talker = adapter.findById(id);

            assertNotNull(talker);
            assertTrue(talker.isEmpty());

            verify(repository).findById(id);
        }
    }

    @Nested
    class FindByEmailTest {

        @InjectMocks
        private TalkerRepositoryAdapter adapter;

        @Mock
        private TalkerRepository repository;

        @Test
        @DisplayName("Deve retornar talker ao encontrar por email")
        void should_return_talker_when_found_by_email() {
            var expected = DataProviderUtil.getSampleDomain();
            var entity = mock(TalkerEntity.class);

            when(this.repository.findByEmail(expected.getEmail())).thenReturn(Optional.of(entity));
            when(entity.toDomain()).thenReturn(expected);

            var talker = this.adapter.findByEmail(expected.getEmail());

            assertNotNull(talker);
            assertTrue(talker.isPresent());
            assertEquals(expected, talker.get());

            verify(this.repository).findByEmail(expected.getEmail());
            verify(entity).toDomain();
        }


        @Test
        @DisplayName("Deve retornar empty quando talker não encontrado pelo id")
        void should_return_empty_when_talker_not_found_by_id() {
            var email = "john.doe@t2r.com";
            when(repository.findByEmail(email)).thenReturn(Optional.empty());

            var talker = adapter.findByEmail(email);

            assertNotNull(talker);
            assertTrue(talker.isEmpty());

            verify(repository).findByEmail(email);
        }
    }
}