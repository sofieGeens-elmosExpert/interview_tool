package be.elmos.interview_tool_spring;

import be.elmos.interview_tool_spring.model.InternPerson;
import be.elmos.interview_tool_spring.model.Language;
import be.elmos.interview_tool_spring.model.Person;
import be.elmos.interview_tool_spring.model.Question;
import be.elmos.interview_tool_spring.model.enums.AnswerType;
import be.elmos.interview_tool_spring.model.enums.Category;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.enums.QuestionType;
import be.elmos.interview_tool_spring.model.persistence.LanguageRepository;
import be.elmos.interview_tool_spring.model.persistence.PersonRepository;
import be.elmos.interview_tool_spring.model.persistence.QuestionRepository;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class InterviewToolSpringApplication {
	//@Autowired
	//private JdbcTemplate jdbcTemplate;

	public static void main(String[] args) {
		SpringApplication.run(InterviewToolSpringApplication.class, args);
	}

	@Bean
	public CommandLineRunner demoInterviewTool(PersonRepository personRepository, QuestionRepository questionRepository) {
		return (args) -> {
			/*
			String sql = "SELECT * FROM interview_tool.dbo.person;";
			System.out.println("\n\nTRY QUERY\n\n");
			List<Person> persons = jdbcTemplate.query(sql, BeanPropertyRowMapper.newInstance(Person.class));
			System.out.println("\n" + sql + "\n");
			persons.forEach(System.out :: println);
			*/
			/*for (Language l : languageRepository.findAll()) {
				System.out.println(l);
			}*/
			System.out.println("\n\nHELLO WORLD \n\n");
			Language language = new Language("sofietaal");
			//languageRepository.save(language);
			Question q =new Question(PersonType.SENIOR, Category.TECHNICAL, QuestionType.MIDDLE, AnswerType.BOOL,"senior???",language);
			questionRepository.save(q);
			System.out.println(q);
			System.out.println(language);
			generatePerson(personRepository);
		};
	}

	private static void generatePerson(PersonRepository personRepository) {
		InternPerson p =new InternPerson("Paesen", "Jack", "jack.paesen@gmail.com", "JP123", String.valueOf(PersonType.MANAGER.getName()));
		System.out.println("dit was niet het probleem: " + p);
		personRepository.save(p);
		//System.out.println(p);
//
//		for (InternPerson person: personRepository.findAll()) {
//			System.out.println("PRINT PERSONS");
//			System.out.println(person.toString());
//		}
	}
}
