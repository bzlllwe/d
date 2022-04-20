package d.d;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;


@EnableRedisHttpSession
@EnableScheduling
@EnableCaching
@EnableJpaAuditing
@SpringBootApplication
public class DApplication {

	public static void main(String[] args) {
		SpringApplication.run(DApplication.class, args);
	}

}
