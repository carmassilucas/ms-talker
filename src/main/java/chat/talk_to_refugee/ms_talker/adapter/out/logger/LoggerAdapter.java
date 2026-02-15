package chat.talk_to_refugee.ms_talker.adapter.out.logger;

import chat.talk_to_refugee.ms_talker.core.port.out.LoggerPort;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerAdapter implements LoggerPort {

    @Override
    public void info(Class<?> clazz, String message) {
        LoggerFactory.getLogger(clazz).info(message);
    }
}
