package br.com.application.school.service.impl;

import br.com.application.school.model.Student;
import br.com.application.school.model.tdo.StudentDTO;
import br.com.application.school.repository.StudentRepository;
import br.com.application.school.service.StudentService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public List<StudentDTO> findAll() {
        return studentRepository.findAll().stream().map(this::toStudentDTO).collect(Collectors.toList());
    }

    @Override
    public ModelAndView verifyIfAllParametersWerePast(StudentDTO dto, BindingResult bindingResult) {
        System.out.println(dto);
        if(bindingResult.hasErrors()) {
            return new ModelAndView("/students/register");
        }
        studentRepository.save(toStudent(dto));
        return new ModelAndView("redirect:/students");
    }

    private StudentDTO toStudentDTO(Student student) {
        return modelMapper.map(student, StudentDTO.class);
    }

    private Student toStudent(StudentDTO studentDTO) {
        return modelMapper.map(studentDTO, Student.class);
    }
}
