package be.elmos.interview_tool_spring.model.persistence;

import be.elmos.interview_tool_spring.model.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CandidateRepository extends JpaRepository<Candidate, Integer> {
    List<Candidate> findAll();

    Candidate findById(int id);

    List<Candidate> findByActive(boolean bool);
    // todo Long instead of Integer?
}

