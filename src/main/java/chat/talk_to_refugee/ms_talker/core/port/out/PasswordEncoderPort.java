package chat.talk_to_refugee.ms_talker.core.port.out;

@SuppressWarnings("unused")
public interface PasswordEncoderPort {

    String encode(CharSequence rawPassword);

    boolean matches(CharSequence rawPassword, String encodedPassword);
}
