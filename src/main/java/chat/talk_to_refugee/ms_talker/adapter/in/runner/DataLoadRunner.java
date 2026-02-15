package chat.talk_to_refugee.ms_talker.adapter.in.runner;

import chat.talk_to_refugee.ms_talker.core.domain.Profile.Name;
import chat.talk_to_refugee.ms_talker.core.port.in.CreateProfilesUseCasePort;
import org.jspecify.annotations.NonNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class DataLoadRunner implements CommandLineRunner {

    private final CreateProfilesUseCasePort createProfiles;

    public DataLoadRunner(CreateProfilesUseCasePort createProfiles) {
        this.createProfiles = createProfiles;
    }

    @Override
    public void run(String @NonNull ... args) {
        var profiles = Arrays.stream(Name.values())
                .map(Name::get)
                .toList();
        this.createProfiles.execute(profiles);
    }
}
