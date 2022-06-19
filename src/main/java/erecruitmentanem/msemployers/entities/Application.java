package erecruitmentanem.msemployers.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "applications")
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

    private Long idJobOffer ;
    private Long idJobSeeker ;

}
