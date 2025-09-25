package chat.talk_to_refugee.ms_talker.adapter.inbound.resource;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.request.CreateTalker;
import chat.talk_to_refugee.ms_talker.core.port.inbound.CreateTalkerUseCasePort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/talkers")
public class TalkerResource {

    private final CreateTalkerUseCasePort create;

    public TalkerResource(CreateTalkerUseCasePort create) {
        this.create = create;
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateTalker requestBody) {
        this.create.execute(requestBody.toDomain());
        return ResponseEntity.noContent().build();
    }
}
