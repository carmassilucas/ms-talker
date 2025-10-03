package chat.talk_to_refugee.ms_talker.util;

import chat.talk_to_refugee.ms_talker.core.domain.Talker;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerLocation;
import chat.talk_to_refugee.ms_talker.core.domain.TalkerType;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

public class DataProviderUtil {

    private DataProviderUtil() {
    }

    public static Talker getSampleDomain() {
        var now = Instant.now();
        return new Talker(
                UUID.randomUUID(),
                "John Doe",
                LocalDate.now(),
                "About me",
                "s3:/profile-photo/john-doe.jpeg",
                new TalkerLocation("ST", "City"),
                TalkerType.Value.REFUGEE.get(),
                "john.doe@t2r.com",
                "john.doe",
                true,
                now,
                now
        );
    }
}
