package chat.talk_to_refugee.ms_talker.adapter.outbound.mapper;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.port.outbound.TalkerMapperAdapterPort;
import org.springframework.stereotype.Component;

@Component
public class UpdateTalkerAdapter implements TalkerMapperAdapterPort {

    private final UpdateTalkerMapper mapper;

    public UpdateTalkerAdapter(UpdateTalkerMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public void update(Talker source, Talker target) {
        this.mapper.update(source, target);
    }
}
