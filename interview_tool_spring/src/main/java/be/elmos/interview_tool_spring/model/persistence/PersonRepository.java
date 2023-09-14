package be.elmos.interview_tool_spring.model.persistence;

import be.elmos.interview_tool_spring.model.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
    Person findById(long id);
}
