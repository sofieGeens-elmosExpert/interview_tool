package be.elmos.interview_tool_spring.model.persistence;

import be.elmos.interview_tool_spring.model.InterviewQuestion;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.Set;

public interface InterviewQuestionRepository extends CrudRepository<InterviewQuestion, InterviewQuestionId> {
    Optional<InterviewQuestion> findById(InterviewQuestionId id);
    Set<InterviewQuestion> findAll();
}
