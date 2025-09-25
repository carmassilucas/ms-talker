package chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record AuthTalkerRequest(@NotBlank @Email String email, @NotBlank String password) {
}
