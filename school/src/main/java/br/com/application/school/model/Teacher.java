package br.com.application.school.model;

import br.com.application.school.model.enums.TeacherStats;
<<<<<<< HEAD
=======
import lombok.AllArgsConstructor;
>>>>>>> origin/main
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
<<<<<<< HEAD
import java.math.BigDecimal;
=======
>>>>>>> origin/main
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
<<<<<<< HEAD
    private BigDecimal salary;
    @Enumerated(EnumType.STRING)
    private TeacherStats status;

    public Teacher(String name, BigDecimal salary, TeacherStats stats) {
        this.name = name;
        this.salary = salary;
        this.status = stats;
=======
    private Double salary;
    @Enumerated(EnumType.STRING)
    private TeacherStats stats;

    public Teacher(String name, Double salary, TeacherStats stats) {
        this.name = name;
        this.salary = salary;
        this.stats = stats;
>>>>>>> origin/main
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

<<<<<<< HEAD
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

=======
    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getStats() {
        return stats.toString();
    }

    public void setStats(TeacherStats stats) {
        this.stats = stats;
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
>>>>>>> origin/main
}
