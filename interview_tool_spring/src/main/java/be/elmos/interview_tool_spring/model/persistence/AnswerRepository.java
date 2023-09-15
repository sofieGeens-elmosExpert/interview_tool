package be.elmos.interview_tool_spring.model.persistence;

import be.elmos.interview_tool_spring.model.Answer;
import be.elmos.interview_tool_spring.model.Candidate;
import be.elmos.interview_tool_spring.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRepository extends JpaRepository<Answer, Long> {
    List<Answer> getAllByQuestion(Question question);
}
