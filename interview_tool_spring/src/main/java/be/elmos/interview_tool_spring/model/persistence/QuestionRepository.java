package be.elmos.interview_tool_spring.model.persistence;

import be.elmos.interview_tool_spring.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface QuestionRepository extends JpaRepository<Question, Long> {
    List<Question> findAllByActive(boolean bool);
    Question findById(long id);
    Question findAllByQuestion(String question);
    @Query(
        value = "SELECT * FROM question q " +
                " WHERE q.active = true" +
                " AND EXISTS (SELECT *" +
                " FROM interview_has_questions iq" +
                " INNER JOIN interview i" +
                " ON iq.interview_id = i.id" +
                " WHERE iq.question_id = q.id" +
                " AND iq.interview_id=?1)"
        ,nativeQuery = true)
    Set<Question> findAllActiveQuestionsByInterviewId(Long id);
}
