package chat.talk_to_refugee.ms_talker.core.port.inbound;

import java.util.UUID;

public interface ToggleActiveProfileUseCasePort {

    void execute(UUID id, Boolean active);
}
