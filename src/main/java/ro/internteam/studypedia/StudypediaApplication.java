package ro.internteam.studypedia;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableJpaRepositories(basePackages = "ro.internteam.studypedia.dao")
@EntityScan(basePackages = "ro.internteam.studypedia.model")
public class StudypediaApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudypediaApplication.class, args);
	}

}

