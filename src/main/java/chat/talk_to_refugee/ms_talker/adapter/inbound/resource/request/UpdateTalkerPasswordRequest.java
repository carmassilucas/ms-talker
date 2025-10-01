package chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request;

import jakarta.validation.constraints.NotBlank;

public record UpdateTalkerPasswordRequest(@NotBlank String currentPassword, @NotBlank String newPassword) {
}
