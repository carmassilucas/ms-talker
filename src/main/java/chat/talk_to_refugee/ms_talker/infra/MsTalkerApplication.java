package chat.talk_to_refugee.ms_talker.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "chat.talk_to_refugee.ms_talker")
@EnableJpaRepositories(basePackages = "chat.talk_to_refugee.ms_talker")
@EntityScan(basePackages = "chat.talk_to_refugee.ms_talker")
public class MsTalkerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsTalkerApplication.class, args);
	}

}
