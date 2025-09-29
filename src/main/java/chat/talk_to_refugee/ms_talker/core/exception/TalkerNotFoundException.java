package chat.talk_to_refugee.ms_talker.core.exception;

public class TalkerNotFoundException extends CommonException {

    public TalkerNotFoundException() {
        super(404, "Talker Already Exists", "Email address is already in use.");
    }
}
