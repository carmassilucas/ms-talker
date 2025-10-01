package chat.talk_to_refugee.ms_talker.adapter.outbound.repository;

import chat.talk_to_refugee.ms_talker.adapter.outbound.mapper.UpdateTalkerMapper;
import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerRepositoryAdapterPort;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

@Component
public class TalkerRepositoryAdapter implements TalkerRepositoryAdapterPort {

    private final TalkerRepository repository;
    private final UpdateTalkerMapper updateMapper;

    public TalkerRepositoryAdapter(TalkerRepository repository,
                                   UpdateTalkerMapper updateMapper) {
        this.repository = repository;
        this.updateMapper = updateMapper;
    }

    @Override
    public Optional<Talker> findByEmail(String email) {
        return this.repository.findByEmail(email).map(TalkerEntity::toDomain);
    }

    @Override
    @Transactional
    public void save(Talker talker) {
        if (talker.getId() == null) {
            this.repository.save(new TalkerEntity(talker));
            return;
        }

        this.repository.save(this.updateMapper.map(talker));
    }

    @Override
    public Optional<Talker> findById(UUID id) {
        return this.repository.findById(id).map(TalkerEntity::toDomain);
    }
}
