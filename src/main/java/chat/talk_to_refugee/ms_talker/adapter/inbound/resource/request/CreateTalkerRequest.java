package chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateTalkerRequest(@NotBlank String fullName,
                                  @NotNull LocalDate birthDate,
                                  @NotNull TalkerType.Value type,
                                  @NotBlank String email,
                                  @NotBlank String password) {

    public Talker toDomain() {
        return new Talker(fullName, birthDate, type, email, password);
    }
}
