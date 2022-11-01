package br.com.application.school.model.tdo;

import br.com.application.school.model.Teacher;
import br.com.application.school.model.enums.TeacherStats;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.web.bind.annotation.ModelAttribute;

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
        return new Teacher(this.getName(), this.getSalary(), this.getStatus());
    }
}
