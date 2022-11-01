package br.com.application.school.service;

import br.com.application.school.model.Teacher;
import br.com.application.school.model.tdo.TeacherDTO;
import br.com.application.school.repository.TeacherRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Autowired
    private ModelMapper modelMapper;

    public List<TeacherDTO> findAll() {
        return teacherRepository.findAll().stream().map(this::toTeacherDTO).collect(Collectors.toList());
    }

    public void saveNewTeacher(TeacherDTO teacherDTO) {
        Teacher teacher = teacherDTO.toTeacher();
        teacherRepository.save(teacher);
    }

    private TeacherDTO toTeacherDTO(Teacher teacher) {
        TeacherDTO dto = modelMapper.map(teacher, TeacherDTO.class);
        return dto;
    }
}
