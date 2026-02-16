package chat.talk_to_refugee.ms_talker.core.exception;

public class UnderageNotAllowedException extends CommonException {

    public UnderageNotAllowedException() {
        super(422, "Underage not allowed", "Registration is not permitted for minors under 18 years of age");
    }
}
