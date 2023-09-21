package be.elmos.interview_tool_spring.model.persistence;

import be.elmos.interview_tool_spring.model.InternPerson;
import org.springframework.data.repository.CrudRepository;

//needed?
public interface PersonRepository extends CrudRepository<InternPerson, Long> {
    InternPerson findById(long id);
}
