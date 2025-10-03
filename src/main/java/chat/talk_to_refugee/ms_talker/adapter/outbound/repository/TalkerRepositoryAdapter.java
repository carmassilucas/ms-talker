package chat.talk_to_refugee.ms_talker.adapter.outbound.repository;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.UUID;

@Component
public class TalkerRepositoryAdapter implements TalkerRepositoryAdapterPort {

    private final TalkerRepository repository;

    public TalkerRepositoryAdapter(TalkerRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(Talker talker) {
        this.repository.save(new TalkerEntity(talker));
    }

    @Override
    public Optional<Talker> findById(UUID id) {
        return this.repository.findById(id).map(TalkerEntity::toDomain);
    }

    @Override
    public Optional<Talker> findByEmail(String email) {
        return this.repository.findByEmail(email).map(TalkerEntity::toDomain);
    }
}
