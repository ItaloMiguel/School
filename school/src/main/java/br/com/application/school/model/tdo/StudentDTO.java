package br.com.application.school.model.tdo;

import br.com.application.school.model.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class StudentDTO {

    @JsonIgnore
    private Long id;
    private String username;
    private String password;

    public Student toStudent() {
        Student student = new Student();
        student.setUsername(this.username);
        student.setPassword(this.password);
        return student;
    }
}
