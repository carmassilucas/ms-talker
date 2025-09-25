package chat.talk_to_refugee.ms_talker.core.exception;

public class TalkerAlreadyExistsException extends RuntimeException {

    public TalkerAlreadyExistsException() {
        super("Endereço de e-mail já está em uso");
    }
}
