package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.Candidate;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class SelectCandidatesDto {
    private EntityManager entityManager;

    @Autowired
    public SelectCandidatesDto(EntityManager em){entityManager = em;}

    public List<Candidate> getAllCandidates(){
        TypedQuery<Candidate> query = entityManager.createQuery("FROM Candidate", Candidate.class);
        return query.getResultList();
    }
}
