package chat.talk_to_refugee.ms_talker.core.exception;

public class TalkerAlreadyExistsException extends CommonException {

    public TalkerAlreadyExistsException() {
        super(422, "Talker Already Exists", "Email address is already in use.");
    }
}
