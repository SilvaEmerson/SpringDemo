package main.java.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import main.java.entities.Person;
import main.java.repositories.PersonRepository;

@SpringBootApplication
@EntityScan("main.java.entities")
@EnableJpaRepositories("main.java.repositories")
public class Application {
	
	private static final Logger log = LoggerFactory.getLogger(Application.class);
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner demo(PersonRepository repository) {
		return (args) -> {
			//salvar algumas pessoas
			repository.save(new Person("Émerson", 18, "Student"));
			repository.save(new Person("Albert", 75, "Scientist"));
			repository.save(new Person("Hawking", 75, "Scientist"));
			
			// 
			/*log.info("Persons found with findAll()");
			log.info("-----------------------------");
			
			for (Person person : repository.findAll()) {
				log.info(person.toString());
			}
			
			log.info("");*/
		};
	}
}
