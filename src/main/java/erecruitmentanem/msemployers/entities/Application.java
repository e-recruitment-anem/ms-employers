package erecruitmentanem.msemployers.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "application")
@AllArgsConstructor
public class Application {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idApplication")
    private Long idApplication ;

    private String letter ;
    private String storagePathCV ;
    private Date date ;
    private String status ;
}
