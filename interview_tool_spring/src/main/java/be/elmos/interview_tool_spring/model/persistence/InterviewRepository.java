package be.elmos.interview_tool_spring.model.persistence;

import be.elmos.interview_tool_spring.model.Interview;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface InterviewRepository extends CrudRepository<Interview, Long> {
    Interview findById(long id);
    List<Interview> findAllInterviewsByPersonId(Long id);
}
