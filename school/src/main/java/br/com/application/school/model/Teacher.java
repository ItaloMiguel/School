package br.com.application.school.model;

import br.com.application.school.model.enums.TeacherStats;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
@NoArgsConstructor
@ToString
public class Teacher implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    private BigDecimal salary;
    @Enumerated(EnumType.STRING)
    private TeacherStats status;

    public Teacher(String name, BigDecimal salary, TeacherStats stats) {
        this.name = name;
        this.salary = salary;
        this.status = stats;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public String getStatus() {
        return status.toString();
    }

    public void setStatus(TeacherStats status) {
        this.status = status;
    }

    public String getStats() {
        return status.toString();
    }

    public void setStats(TeacherStats stats) {
        this.status = stats;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Teacher teacher = (Teacher) o;
        return id != null && Objects.equals(id, teacher.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
