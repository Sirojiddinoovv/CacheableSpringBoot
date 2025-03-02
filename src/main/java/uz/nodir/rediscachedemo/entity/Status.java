package uz.nodir.rediscachedemo.entity;

import jakarta.persistence.*;
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

    @Column(name = "value")
    private Integer value;

    @Column(name = "description")
    private String description;

}
