package chat.talk_to_refugee.ms_talker.core.exception;

public class PasswordDoesNotMatchesException extends CommonException {

    public PasswordDoesNotMatchesException() {
        super(422, "Password Does Not Matches", "Incorrect password for email address.");
    }
}
