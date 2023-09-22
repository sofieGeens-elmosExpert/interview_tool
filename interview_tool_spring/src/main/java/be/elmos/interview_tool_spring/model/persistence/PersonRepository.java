package be.elmos.interview_tool_spring.model.persistence;

import be.elmos.interview_tool_spring.model.InternPerson;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

//needed?
public interface PersonRepository extends CrudRepository<InternPerson, Long> {
    InternPerson findById(long id);
    List<InternPerson> findAllByActive(Boolean bool);
    InternPerson findByEmail(String mail);
}
