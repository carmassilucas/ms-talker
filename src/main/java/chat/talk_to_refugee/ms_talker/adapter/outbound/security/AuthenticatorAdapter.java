package chat.talk_to_refugee.ms_talker.adapter.outbound.security;

import chat.talk_to_refugee.ms_talker.adapter.inbound.resource.response.AuthTalkerResponse;
import chat.talk_to_refugee.ms_talker.core.port.outbound.AuthenticatorAdapterPort;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.jwt.JwtClaimsSet;
import org.springframework.security.oauth2.jwt.JwtEncoder;
import org.springframework.security.oauth2.jwt.JwtEncoderParameters;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component
public class AuthenticatorAdapter implements AuthenticatorAdapterPort {

    private final JwtEncoder encoder;
    private final String applicationName;

    public AuthenticatorAdapter(JwtEncoder encoder, @Value("${spring.application.name}") String applicationName) {
        this.encoder = encoder;
        this.applicationName = applicationName;
    }

    @Override
    public AuthTalkerResponse auth(String subject) {
        var now = Instant.now();
        var expiresIn = 300L;

        var claims = JwtClaimsSet.builder()
                .issuer(this.applicationName)
                .subject(subject)
                .issuedAt(now)
                .expiresAt(now.plusSeconds(expiresIn))
                .build();

        var parameters = JwtEncoderParameters.from(claims);
        var token = this.encoder.encode(parameters).getTokenValue();

        return new AuthTalkerResponse(token, expiresIn);
    }
}
