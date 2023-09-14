package be.elmos.interview_tool_spring;

import be.elmos.interview_tool_spring.model.Manager;
import be.elmos.interview_tool_spring.model.Person;
import be.elmos.interview_tool_spring.model.Type;
import be.elmos.interview_tool_spring.model.persistence.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InterviewToolSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(InterviewToolSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoInterviewTool(PersonRepository personRepository) {
		return (args) -> {
			generatePerson(personRepository);
		};
	}

	private static void generatePerson(PersonRepository personRepository) {
		personRepository.save(new Manager("Jack", "Paesen", "jack.paesen@gmail.com", "JP123", Type.MANAGER));

		for (Person person: personRepository.findAll()) {
			System.out.println(person.toString());
		}
	}
}
