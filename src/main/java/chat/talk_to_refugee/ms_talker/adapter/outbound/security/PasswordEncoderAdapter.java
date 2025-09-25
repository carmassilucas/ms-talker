package chat.talk_to_refugee.ms_talker.adapter.outbound.security;

import chat.talk_to_refugee.ms_talker.core.port.outbound.PasswordEncoderAdapterPort;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncoderAdapter implements PasswordEncoderAdapterPort {
    
    private final PasswordEncoder encoder;

    public PasswordEncoderAdapter(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public String encode(CharSequence rawPassword) {
        return this.encoder.encode(rawPassword);
    }
}
