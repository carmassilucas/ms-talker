package chat.talk_to_refugee.ms_talker.adapter.in.web.request;

import chat.talk_to_refugee.ms_talker.core.domain.Profile;
import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record CreateTalkerRequest(
        @NotBlank
        String fullName,

        @NotNull
        LocalDate birthDate,

        @NotNull
        Profile.Name profile,

        @NotBlank
        String email,

        @NotBlank
        String password
) {

    public Talker toDomain() {
        return new Talker(this.fullName, this.birthDate, this.profile.get(), this.email, this.password);
    }
}
