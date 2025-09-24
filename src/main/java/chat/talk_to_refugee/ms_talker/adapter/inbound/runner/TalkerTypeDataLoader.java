package chat.talk_to_refugee.ms_talker.adapter.inbound.runner;

import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import chat.talk_to_refugee.ms_talker.core.port.inbound.CreateTalkerTypeUseCasePort;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TalkerTypeDataLoader implements CommandLineRunner {

    private final CreateTalkerTypeUseCasePort create;

    public TalkerTypeDataLoader(CreateTalkerTypeUseCasePort create) {
        this.create = create;
    }

    @Override
    public void run(String... args) {
        for (TalkerType.Value value : TalkerType.Value.values()) {
            this.create.execute(value.get());
        }
    }
}
