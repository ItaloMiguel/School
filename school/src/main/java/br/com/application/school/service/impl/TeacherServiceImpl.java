package br.com.application.school.service.impl;

import br.com.application.school.model.Teacher;
import br.com.application.school.model.enums.TeacherStats;
import br.com.application.school.model.tdo.TeacherDTO;
import br.com.application.school.repository.TeacherRepository;
import br.com.application.school.service.TeacherService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(this::toTeacherDTO).collect(Collectors.toList());
    }

    @Override
    public void saveNewTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherDTO.toTeacher();
        teacherRepository.save(teacher);
    }

    @Override
    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }


    private TeacherDTO toTeacherDTO(Teacher teacher) {
        return modelMapper.map(teacher, TeacherDTO.class);
    }

    @Override
    public ModelAndView verifyIfAllParametersWerePast(TeacherDTO teacherDTO, BindingResult bindingResult) {
        System.out.println(teacherDTO);
        if(bindingResult.hasErrors()) {
            ModelAndView mv = new ModelAndView("teachers/register");
            mv.addObject("teacherStatus", TeacherStats.values());
            return mv;
        } else {
            saveNewTeacher(teacherDTO);
            return new ModelAndView("redirect:/teachers");
        }
    }

    @Override
    public Optional<TeacherDTO> findById(Long id) {
        Optional<Teacher> teacher = teacherRepository.findById(id);
        return teacher.map(this::toTeacherDTO);
    }

    @Override
    public Optional<Teacher> findByIdForEdit(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public Optional<Teacher> findByIdUpdate(Long id) {
        return teacherRepository.findById(id);
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
    }
}
