package projects.cloud.EventOrganiser.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableJpaRepositories("projects.cloud.EventOrganiser.daos")
@ComponentScan(basePackages = { "projects.cloud.EventOrganiser.resources" })
@EntityScan("projects.cloud.EventOrganiser.models")
public class App {

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
