package chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response;

import chat.talk_to_refugee.ms_talker.core.domain.TalkerLocation;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;

import java.time.LocalDate;
import java.util.UUID;

public record TalkerProfileResponse(UUID id,
                                    String fullName,
                                    LocalDate birthDate,
                                    String profilePhoto,
                                    String aboutMe,
                                    TalkerLocation location,
                                    TalkerType type,
                                    Boolean active) {
}
