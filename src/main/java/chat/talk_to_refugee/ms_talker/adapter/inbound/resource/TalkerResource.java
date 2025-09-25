package chat.talk_to_refugee.ms_talker.adapter.inbound.resource;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.AuthTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.CreateTalkerRequest;
import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.AuthTalkerResponse;
import chat.talk_to_refugee.ms_talker.core.port.inbound.AuthTalkerUseCasePort;
import chat.talk_to_refugee.ms_talker.core.port.inbound.CreateTalkerUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/talkers")
public class TalkerResource {

    private final CreateTalkerUseCasePort create;
    private final AuthTalkerUseCasePort auth;

    public TalkerResource(CreateTalkerUseCasePort create, AuthTalkerUseCasePort auth) {
        this.create = create;
        this.auth = auth;
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
}
