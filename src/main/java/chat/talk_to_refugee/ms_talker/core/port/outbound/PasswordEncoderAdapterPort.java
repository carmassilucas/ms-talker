package chat.talk_to_refugee.ms_talker.core.port.outbound;

public interface PasswordEncoderAdapterPort {

    String encode(CharSequence rawPassword);
    boolean matches(CharSequence rawPassword, String encodedPassword);
}
