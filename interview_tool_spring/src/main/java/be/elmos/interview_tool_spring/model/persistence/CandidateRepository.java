package be.elmos.interview_tool_spring.model.persistence;

import be.elmos.interview_tool_spring.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Long> {
    Candidate findById(long id);

    List<Candidate> findAllByActive(boolean bool);

    Candidate findByEmail(String email);
}

