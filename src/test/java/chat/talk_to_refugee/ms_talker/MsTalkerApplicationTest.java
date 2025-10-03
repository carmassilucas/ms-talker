package chat.talk_to_refugee.ms_talker;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MsTalkerApplicationTest {

    @Test
    @DisplayName("Aplicação deve subir sem exceções")
    void context_loads() {
        MsTalkerApplication.main(new String[] {});
    }
}