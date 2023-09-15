package be.elmos.interview_tool_spring;

import be.elmos.interview_tool_spring.model.Manager;
import be.elmos.interview_tool_spring.model.Person;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class InterviewToolSpringApplication {
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(InterviewToolSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoInterviewTool(PersonRepository personRepository) {
		return (args) -> {
			/*
			String sql = "SELECT * FROM interview_tool.dbo.person;";
			System.out.println("\n\nTRY QUERY\n\n");
			List<Person> persons = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person.class));
			System.out.println("\n" + sql + "\n");
			persons.forEach(System.out :: println);
			*/
			generatePerson(personRepository);
		};
	}

	private static void generatePerson(PersonRepository personRepository) {
		personRepository.save(new Manager("Jack", "Paesen", "jack.paesen@gmail.com", "JP123", PersonType.MANAGER));

		for (Person person: personRepository.findAll()) {
			System.out.println(person.toString());
		}
	}
}
