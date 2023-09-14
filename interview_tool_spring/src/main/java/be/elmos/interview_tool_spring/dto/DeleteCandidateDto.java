package be.elmos.interview_tool_spring.dto;

import be.elmos.interview_tool_spring.model.Candidate;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class DeleteCandidateDto {

    private EntityManager entityManager;

    @Autowired
    public DeleteCandidateDto(EntityManager em) {entityManager = em;}

    @Transactional
    public void deleteCandidate(int id){
        Candidate candidate = entityManager.find(Candidate.class,id);
        entityManager.remove(candidate);}
}
