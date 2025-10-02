package chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerLocation;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;

import java.time.LocalDate;
import java.util.Objects;

public record UpdateTalkerRequest(String fullName,
                                  LocalDate birthDate,
                                  String aboutMe,
                                  TalkerLocation location,
                                  TalkerType type) {

    public Talker toDomain() {
        return new Talker(fullName, birthDate, aboutMe, Objects.requireNonNullElseGet(location, TalkerLocation::new), type);
    }
}
