package br.com.application.school.model.tdo;

import br.com.application.school.model.Teacher;
import br.com.application.school.model.enums.TeacherStats;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class TeacherDTO {

    @JsonIgnore
    private Long id;
    @NotBlank
    @NotNull
    private String name;
    @NotNull
    @DecimalMin("0.0")
    private BigDecimal salary;
    private TeacherStats status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getSalary() {
        return salary;
    }

    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public TeacherStats getStatus() {
        return status;
    }

    public void setStatus(TeacherStats status) {
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Teacher toTeacher() {
        Teacher teacher = new Teacher();
        teacher.setId(this.getId());
        teacher.setName(this.getName());
        teacher.setSalary(this.getSalary());
        teacher.setStatus(this.getStatus());
        return teacher;
    }

    public void fromTeacher(Teacher teacher) {
        this.name = teacher.getName();
        this.salary = teacher.getSalary();
        this.status = teacher.getStatus();
    }


    public Teacher toTeacherUpdate(Teacher teacher) {
        teacher.setName(this.getName());
        teacher.setSalary(this.getSalary());
        teacher.setStatus(this.getStatus());
        return teacher;
    }
}
