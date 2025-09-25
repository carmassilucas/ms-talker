package chat.talk_to_refugee.ms_talker.core.exception;

public class UnderageNotAllowedException extends RuntimeException {

    public UnderageNotAllowedException() {
        super("Não é permitido o cadastro de menores de idade");
    }
}
