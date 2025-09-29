package chat.talk_to_refugee.ms_talker.core.exception;

public class UnderageNotAllowedException extends CommonException {

    public UnderageNotAllowedException() {
        super(422, "Underage Registration Not Allowed", "Registration of minors is not allowed.");
    }
}
