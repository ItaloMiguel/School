package br.com.application.school.service;

import br.com.application.school.model.Teacher;
import br.com.application.school.model.tdo.TeacherDTO;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Optional;

public interface TeacherService {

    public List<TeacherDTO> findAll();

    public void saveNewTeacher(TeacherDTO teacherDTO);

    public void save(Teacher teacher);

    public ModelAndView verifyIfAllParametersWerePast(TeacherDTO teacherDTO, BindingResult bindingResult);

    public Optional<TeacherDTO> findById(Long id);

    public Optional<Teacher> findByIdForEdit(Long id);

    public Optional<Teacher> findByIdUpdate(Long id);
    public void deleteTeacher(Long id);
}
