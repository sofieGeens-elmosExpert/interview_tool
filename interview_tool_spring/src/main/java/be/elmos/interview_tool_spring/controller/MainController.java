package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.InterviewDto;
import be.elmos.interview_tool_spring.model.Interview;
import be.elmos.interview_tool_spring.model.persistence.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping
public class MainController {

    @Autowired
    private InterviewRepository interviewRepository;

    @GetMapping("/index")
    public String logInPage(){
        return "index";
    }

    @GetMapping
    public String dashboard() {
        Long personId = 1L; // hardcoded; get id from session
        List<Interview> interviews = interviewRepository.findAllInterviewsByPersonId(personId);
        List<InterviewDto> dtos = new ArrayList<>();
        for (Interview i : interviews) dtos.add(convertToDto(i));

        return "dashboard";
    }

    private InterviewDto convertToDto(Interview interview) {
        return new InterviewDto();
    }

    // TODO hier getmapping voor dashboard --> Get INTERVIEWS? En dus niet in InterviewController ?
}
