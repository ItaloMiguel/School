package br.com.application.school.service;

import br.com.application.school.model.Student;
import br.com.application.school.model.tdo.StudentDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

public interface StudentService {
    List<StudentDTO> findAll();

    ModelAndView verifyIfAllParametersWerePast(StudentDTO dto, BindingResult bindingResult);
}
