package br.com.application.school.controller;

import br.com.application.school.model.enums.TeacherStats;
import br.com.application.school.model.tdo.TeacherDTO;
import br.com.application.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
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

    @GetMapping("/teachers/register")
    public ModelAndView newTeacher(TeacherDTO dto) {
        ModelAndView mv = new ModelAndView("teachers/register");
        mv.addObject("teacherStatus", TeacherStats.values());
        return mv;
    }

    @PostMapping("/teachers")
    public ModelAndView create(@Valid TeacherDTO dto, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("teachers/register");
            mv.addObject("teacherStatus", TeacherStats.values());
            return mv;
        } else {
            teacherService.saveNewTeacher(dto);
            return new ModelAndView("redirect:/teachers");
        }
    }
}
