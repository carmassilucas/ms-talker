package chat.talk_to_refugee.ms_talker.adapter.outbound.repository;

import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerTypeRepositoryAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class TalkerTypeRepositoryAdapter implements TalkerTypeRepositoryAdapterPort {

    private final TalkerTypeRepository repository;

    public TalkerTypeRepositoryAdapter(TalkerTypeRepository repository) {
        this.repository = repository;
    }

    @Override
    public void save(TalkerType type) {
        var entity = new TalkerTypeEntity(type.getId(), type.getDescription());
        this.repository.save(entity).toDomain();
    }
}
