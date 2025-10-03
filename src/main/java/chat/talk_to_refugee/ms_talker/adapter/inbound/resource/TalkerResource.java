package chat.talk_to_refugee.ms_talker.adapter.inbound.resource;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.AuthTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.CreateTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.UpdateTalkerPasswordRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.UpdateTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.AuthTalkerResponse;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.TalkerProfileResponse;
import chat.talk_to_refugee.ms_talker.core.port.inbound.*;
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
    private final ToggleActiveProfileUseCasePort toggle;
    private final UpdateTalkerPasswordUseCasePort password;
    private final UpdateTalkerUseCasePort update;

    public TalkerResource(CreateTalkerUseCasePort create,
                          AuthTalkerUseCasePort auth,
                          TalkerProfileUseCasePort profile,
                          ToggleActiveProfileUseCasePort toggle,
                          UpdateTalkerPasswordUseCasePort password,
                          UpdateTalkerUseCasePort update) {
        this.create = create;
        this.auth = auth;
        this.profile = profile;
        this.toggle = toggle;
        this.password = password;
        this.update = update;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateTalkerRequest requestBody) {
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

    @PatchMapping(value = "/activate")
    public ResponseEntity<Void> activate(JwtAuthenticationToken token) {
        var id = UUID.fromString(token.getName());
        this.toggle.execute(id, true);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/disable")
    public ResponseEntity<Void> disable(JwtAuthenticationToken token) {
        var id = UUID.fromString(token.getName());
        this.toggle.execute(id, false);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<Void> update(JwtAuthenticationToken token,
                                       @RequestBody @Valid UpdateTalkerRequest requestBody) {
        var id = UUID.fromString(token.getName());
        this.update.execute(id, requestBody);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping(value = "/password")
    public ResponseEntity<Void> password(JwtAuthenticationToken token,
                                            @RequestBody @Valid UpdateTalkerPasswordRequest requestBody) {
        var id = UUID.fromString(token.getName());
        this.password.execute(id, requestBody);
        return ResponseEntity.noContent().build();
    }
}
