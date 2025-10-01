package chat.talk_to_refugee.ms_talker.adapter.inbound.resource;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.AuthTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.CreateTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.UpdateTalkerPasswordRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.AuthTalkerResponse;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.TalkerProfileResponse;
import chat.talk_to_refugee.ms_talker.core.port.inbound.AuthTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.inbound.CreateTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.inbound.TalkerProfileUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.inbound.UpdateTalkerPasswordUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = "/talkers")
public class TalkerResource {

    private final CreateTalkerUseCasePort create;
    private final AuthTalkerUseCasePort auth;
    private final TalkerProfileUseCasePort profile;
    private final UpdateTalkerPasswordUseCasePort update;

    public TalkerResource(CreateTalkerUseCasePort create,
                          AuthTalkerUseCasePort auth,
                          TalkerProfileUseCasePort profile,
                          UpdateTalkerPasswordUseCasePort update) {
        this.create = create;
        this.auth = auth;
        this.profile = profile;
        this.update = update;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid CreateTalkerRequest requestBody) {
        this.create.execute(requestBody.toDomain());
        return ResponseEntity.noContent().build();
    }

    @PostMapping(value = "/auth")
    public ResponseEntity<AuthTalkerResponse> auth(@RequestBody @Valid AuthTalkerRequest requestBody) {
        return ResponseEntity.ok(this.auth.execute(requestBody));
    }

    @GetMapping(value = "/profile")
    public ResponseEntity<TalkerProfileResponse> profile(JwtAuthenticationToken token) {
        var id = UUID.fromString(token.getName());
        return ResponseEntity.ok(this.profile.execute(id));
    }

    @PatchMapping(value = "/password")
    public ResponseEntity<?> updatePassword(JwtAuthenticationToken token,
                                            @RequestBody @Valid UpdateTalkerPasswordRequest requestBody) {
        var id = UUID.fromString(token.getName());
        this.update.execute(id, requestBody);
        return ResponseEntity.noContent().build();
    }
}
