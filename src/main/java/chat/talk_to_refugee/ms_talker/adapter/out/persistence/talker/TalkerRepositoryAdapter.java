package chat.talk_to_refugee.ms_talker.adapter.out.persistence.talker;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.port.out.TalkerRepositoryPort;
import org.springframework.stereotype.Component;

@Component
public class TalkerRepositoryAdapter implements TalkerRepositoryPort {

    private final TalkerEntityRepository repository;

    public TalkerRepositoryAdapter(TalkerEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public Boolean existsByEmail(String email) {
        return this.repository.existsByEmail(email);
    }

    @Override
    public void save(Talker talker) {
        var entity = new TalkerEntity(talker);
        this.repository.save(entity);
    }
}
