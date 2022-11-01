package br.com.application.school.controller;

import br.com.application.school.model.Teacher;
import br.com.application.school.model.enums.TeacherStats;
import br.com.application.school.model.tdo.TeacherDTO;
import br.com.application.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.List;

@Controller
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping("/teachers")
    public ModelAndView index() {
        List<TeacherDTO> teacherList = teacherService.findAll();
        ModelAndView mv = new ModelAndView("teachers/index");
        mv.addObject("teachers", teacherList);
        return mv;
    }
}
