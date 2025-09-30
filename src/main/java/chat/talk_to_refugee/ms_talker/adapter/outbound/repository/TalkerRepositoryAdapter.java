package chat.talk_to_refugee.ms_talker.adapter.outbound.repository;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class TalkerRepositoryAdapter implements TalkerRepositoryAdapterPort {

    private final TalkerRepository repository;

    public TalkerRepositoryAdapter(TalkerRepository repository) {
        this.repository = repository;
    }

    @Override
    public Optional<Talker> findByEmail(String email) {
        return this.repository.findByEmail(email).map(TalkerEntity::toDomain);
    }

    @Override
    public void save(Talker talker) {
        var type = new TalkerTypeEntity(
                talker.getType().getId(), talker.getType().getDescription()
        );

        var entity = TalkerEntity.builder()
                .fullName(talker.getFullName())
                .birthDate(talker.getBirthDate())
                .type(type)
                .email(talker.getEmail())
                .password(talker.getPassword())
                .build();

        this.repository.save(entity);
    }
}
