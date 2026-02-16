package chat.talk_to_refugee.ms_talker.adapter.out.persistence.profile;

import chat.talk_to_refugee.ms_talker.core.domain.Profile;
import chat.talk_to_refugee.ms_talker.core.port.out.ProfileRepositoryPort;
import org.springframework.stereotype.Component;

import java.util.stream.StreamSupport;

@Component
public class ProfileRepositoryAdapter implements ProfileRepositoryPort {

    private final ProfileEntityRepository repository;

    public ProfileRepositoryAdapter(ProfileEntityRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveAll(Iterable<Profile> profiles) {
        var entities = StreamSupport.stream(profiles.spliterator(), false)
                .map(ProfileEntity::new)
                .toList();
        this.repository.saveAll(entities);
    }
}
