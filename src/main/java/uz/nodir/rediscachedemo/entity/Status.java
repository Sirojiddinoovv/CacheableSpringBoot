package uz.nodir.rediscachedemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

/**
 * Created by Nodir
 * on Date 02 март, 2025
 * Java Spring Boot by Davr Coders
 */

@Getter
@Setter
@ToString
@Entity
@Table(name = "status")
@AllArgsConstructor
@NoArgsConstructor
public class Status extends BaseEntity {
    @SequenceGenerator(
            name = "status_seq",
            sequenceName = "status_seq",
            allocationSize = 1
    )
    @GeneratedValue(
            generator = "status_seq",
            strategy = GenerationType.SEQUENCE
    )
    @Id
    private Long id;

    @Column(name = "code")
    private Integer code;

    @Column(name = "description")
    private String description;

    public Status(Integer code, String definition) {
        this.code = code;
        this.description = definition;
    }
}
