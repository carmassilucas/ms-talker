package chat.talk_to_refugee.ms_talker.core.exception;

public class TalkerAlreadyExistsException extends CommonException {

    public TalkerAlreadyExistsException(int httpStatusCode) {
        super(httpStatusCode, "Talker Already Exists", "Email address is already in use.");
    }
}
