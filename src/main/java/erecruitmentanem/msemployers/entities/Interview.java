package erecruitmentanem.msemployers.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@Table(name = "interviews")
@AllArgsConstructor
public class Interview {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idInterview")
    private Long idInterview ;

    private Date date ;
    private int duration ;
    private String place ;
    private String other ;
    private String result ;
    private String status ;

}
