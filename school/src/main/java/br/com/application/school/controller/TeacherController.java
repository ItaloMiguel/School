package br.com.application.school.controller;

import br.com.application.school.model.Teacher;
import br.com.application.school.model.enums.TeacherStats;
import br.com.application.school.model.tdo.TeacherDTO;
import br.com.application.school.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/teachers")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @GetMapping
    public ModelAndView index() {
        List<TeacherDTO> teacherList = teacherService.findAll();
        ModelAndView mv = new ModelAndView("teachers/index");
        mv.addObject("teachers", teacherList);
        return mv;
    }

    @GetMapping("/register")
    public ModelAndView newTeacher(TeacherDTO dto) {
        ModelAndView mv = new ModelAndView("teachers/register");
        mv.addObject("teacherStatus", TeacherStats.values());
        return mv;
    }

    @PostMapping
    public ModelAndView create(@Valid TeacherDTO dto, BindingResult bindingResult) {
        return teacherService.verifyIfAllParametersWerePast(dto ,bindingResult);
    }

    @GetMapping("/{id}")
    public ModelAndView show(@PathVariable Long id) {
        Optional<TeacherDTO> teacherDTO = teacherService.findById(id);
        if(teacherDTO.isPresent()) {
            TeacherDTO teacher = teacherDTO.get();
            ModelAndView mv = new ModelAndView("/teachers/show");
            return mv.addObject("teacher", teacher);
        }
        return new ModelAndView("redirect:/teachers");
    }

    @GetMapping("/{id}/edit")
    public ModelAndView edit(@PathVariable Long id, TeacherDTO teacherDTO) {
        Optional<Teacher> optional = teacherService.findByIdForEdit(id);
        if(optional.isPresent()) {
            Teacher teacher = optional.get();
            teacherDTO.fromTeacher(teacher);
            ModelAndView mv = new ModelAndView("teachers/edit");
            mv.addObject("teacherStatus", TeacherStats.values());
            mv.addObject("teacherId", teacher.getId());
            return mv;
        }
        return new ModelAndView("redirect:/teachers");
    }

    @PostMapping("/{id}")
    public ModelAndView update(@PathVariable Long id, @Valid TeacherDTO teacherDTO, BindingResult bindingResult) {
        ModelAndView mv = new ModelAndView("/teachers/edit");
        if (bindingResult.hasErrors()) {
            mv.addObject("teacherStatus", TeacherStats.values());
            return mv;
        } else {
            Optional<Teacher> optional = teacherService.findByIdUpdate(id);
            if (optional.isPresent()) {
                Teacher teacher = teacherDTO.toTeacherUpdate(optional.get());
                teacherService.save(teacher);
                System.out.println(teacher);
                return new ModelAndView("redirect:/teachers");
            }
        }
        return mv;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView delete(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
        return new ModelAndView("redirect:/teachers");
    }

}
