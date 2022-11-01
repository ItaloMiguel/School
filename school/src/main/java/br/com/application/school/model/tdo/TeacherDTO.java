package br.com.application.school.model.tdo;

import br.com.application.school.model.enums.TeacherStats;
import lombok.*;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class TeacherDTO {

    private Long id;
    private String name;
    private Double salary;
    private TeacherStats stats;
}
