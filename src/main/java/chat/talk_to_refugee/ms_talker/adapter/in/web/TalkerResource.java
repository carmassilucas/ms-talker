package chat.talk_to_refugee.ms_talker.adapter.in.web;

import chat.talk_to_refugee.ms_talker.adapter.in.web.request.CreateTalkerRequest;
import chat.talk_to_refugee.ms_talker.core.port.in.CreateTalkerUseCasePort;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/talkers")
public class TalkerResource {

    private final CreateTalkerUseCasePort createTalker;

    public TalkerResource(CreateTalkerUseCasePort createTalker) {
        this.createTalker = createTalker;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid CreateTalkerRequest requestBody) {
        this.createTalker.execute(requestBody.toDomain());
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
