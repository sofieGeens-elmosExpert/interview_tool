package be.elmos.interview_tool_spring.controller;

import be.elmos.interview_tool_spring.dto.SelectPersonDto;
import be.elmos.interview_tool_spring.dto.UpdatePersonDto;
import be.elmos.interview_tool_spring.model.InternPerson;
import be.elmos.interview_tool_spring.model.enums.PersonType;
import be.elmos.interview_tool_spring.model.persistence.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

//needed??
@Controller
@RequestMapping("/employees")
public class PersonController {

    @Autowired
    private PersonRepository personRepository;

    @GetMapping
    public String getAllEmployees(Model model) {
        //Only get active Employees (soft delete)
        Iterable<InternPerson> employees = personRepository.findAllByActive(true);
        List<SelectPersonDto> dtos = new ArrayList<>();
        //System.out.println("SHOW EMPLOYEE\n" + employees.iterator().next());
        employees.forEach(p -> dtos.add(convertToSelectDTO(p)));
        //System.out.println("SHOW EMPLOYEE\n" + dtos.iterator().next());
        model.addAttribute("employees", dtos);
        return "employees";
    }

    //soft delete
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable(value = "id") int id){
        InternPerson employee = personRepository.findById(id);
        employee.setActive(false);
        personRepository.save(employee);

        return "redirect:/employees";
    }

    //redirects to a page where information can be changed
    @GetMapping("/edit/{id}")
    public String editEmployee(@PathVariable(value = "id") int id, Model model) {
        InternPerson employee = personRepository.findById(id);
        UpdatePersonDto dto = convertToUpdateDTO(employee);
        model.addAttribute("employee",dto);
        model.addAttribute("id", id);

        return "update-employee";
    }

    //updates the information and redirects to overview page
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable(value = "id") long id, UpdatePersonDto employee, BindingResult result) {
        if (result.hasErrors()) {
            return "update-employee";
        }
        InternPerson emp = convertToUpdateEntity(employee, id);
        personRepository.save(emp);
        return "redirect:/employees";
    }

    @GetMapping("/new")
    public String newEmployee(Model model) {
        UpdatePersonDto dto = new UpdatePersonDto();
        model.addAttribute("employee",dto);
        model.addAttribute("exists","");
        return "new-employee";
    }

    @PostMapping("/add") // todo verify matching passwords
    public String addEmployee(UpdatePersonDto employee, BindingResult result, Model model) {
        if (result.hasErrors()) {
            System.out.println("ADD EMPLOYEE: ERRORS");
            boolean shown = false;
            for (ObjectError er: result.getAllErrors()) {
                System.out.println(er);
                if (!shown) {
                    model.addAttribute("exists", er.toString());
                    shown = true; // todo test and check
                }
            }
            model.addAttribute("exists",""); // todo show errors ?
            UpdatePersonDto dto = new UpdatePersonDto();
            model.addAttribute("employee",dto);
            return "new-employee";
        }
        if (exists(employee)) {
            System.out.println("EMPLOYEE EXISTS");
            model.addAttribute("exists","An employee with this e-mail already exists");
            // fill information back to avoid emptying it on error
            UpdatePersonDto dto = new UpdatePersonDto();
            dto.setFirstName(employee.getFirstName());
            dto.setLastName(employee.getLastName());
            dto.setRole(employee.getRole());
            model.addAttribute("employee",dto);
            return "new-employee";
        }
        System.out.println("NEW EMPLOYEE, PASS " + employee.getPassword());
        InternPerson emp = convertToUpdateEntity(employee);
        System.out.println("NEW EMPLOYEE, PASS " + emp.getPassword());
        

        personRepository.save(emp);
        return "redirect:/employees";
    }

    public SelectPersonDto convertToSelectDTO(InternPerson employee) {
        String role = setRole(employee.getRole());
        return new SelectPersonDto(employee.getLastName(),employee.getFirstName(),employee.getEmail(),role,employee.getId());
    }

    public UpdatePersonDto convertToUpdateDTO(InternPerson employee) {
        String role = setRole(employee.getRole());
        return new UpdatePersonDto(employee.getLastName(),employee.getFirstName(),employee.getEmail(),role,employee.getPassword());
    }

    public InternPerson convertToUpdateEntity(UpdatePersonDto dto, long id) {
        PersonType role = switch (dto.getRole()) {
            case "manager" -> PersonType.MANAGER;
            case "recruiter" -> PersonType.RECRUITER;
            default -> PersonType.EMPTY;
        };
        InternPerson employee = new InternPerson(dto.getFirstName(),dto.getLastName(),dto.getEmail(),String.valueOf(role.getName()),dto.getPassword());
        employee.setId(id);
        return employee;
    }

    public InternPerson convertToUpdateEntity(UpdatePersonDto dto) {
        PersonType role = switch (dto.getRole()) {
            case "m" -> PersonType.MANAGER;
            case "r" -> PersonType.RECRUITER;
            default -> PersonType.EMPTY;
        };
        return new InternPerson(dto.getFirstName(),dto.getLastName(),dto.getEmail(),dto.getPassword(),String.valueOf(role.getName()));
    }

    public Boolean exists(UpdatePersonDto dto) {
        InternPerson employee = convertToUpdateEntity(dto);
        return personRepository.findByEmail(employee.getEmail()) != null;
    }

    public String setRole(PersonType r) {
        String  par = "";
        switch (r) {
            case MANAGER -> par = "manager";
            case RECRUITER -> par = "recruiter";
            default -> par = "not specified";
        }
        System.out.println("role in dto:"+par);
        return par;
    }

}
