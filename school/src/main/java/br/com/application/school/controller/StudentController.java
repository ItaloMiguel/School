package br.com.application.school.controller;

import br.com.application.school.model.tdo.StudentDTO;
import br.com.application.school.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mv = new ModelAndView("students/index");
        List<StudentDTO> studentsList = studentService.findAll();
        mv.addObject("students", studentsList);
        return mv;
    }

    @GetMapping("/register")
    public ModelAndView newStudent(StudentDTO studentDTO) {
        ModelAndView mv = new ModelAndView("students/register");
        return mv;
    }

    @PostMapping
    public ModelAndView create(@Valid StudentDTO dto, BindingResult bindingResult) {
        return studentService.verifyIfAllParametersWerePast(dto ,bindingResult);
    }
}
