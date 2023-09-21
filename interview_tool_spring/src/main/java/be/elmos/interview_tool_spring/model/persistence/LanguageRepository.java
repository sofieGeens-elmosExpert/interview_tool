package be.elmos.interview_tool_spring.model.persistence;

import be.elmos.interview_tool_spring.model.Language;
import org.springframework.data.repository.CrudRepository;

public interface LanguageRepository extends CrudRepository<Language,Long> {
}
