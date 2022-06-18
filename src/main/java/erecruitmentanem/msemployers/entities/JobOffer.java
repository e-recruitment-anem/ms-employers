package erecruitmentanem.msemployers.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import erecruitmentanem.msemployers.enums.FamilySituation;
import erecruitmentanem.msemployers.enums.MillitaryStatus;
import erecruitmentanem.msemployers.enums.Gender;
import erecruitmentanem.msemployers.enums.Mobility;
import javax.persistence.*;
import java.util.Date;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "jobOffers")
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idJobOffer")
    private Long idJobOffer;

    private int agency ;
    private String title ;
    private int positionsNumber ;
    private int avaialablePositionsNumber;
    private int jobTitle ;//nomocloture
    private String workAddress ;
    private int minAge ;
    private int maxAge ;
    private boolean close ;

    @Enumerated(EnumType.STRING)
    private Gender gender ;

    private String contractType ;
    private Date closedAt ;
    private Date duration ;

    private String qualificationLevel ;
    private String educationLevel ;

    @Enumerated(EnumType.STRING)
    private Mobility mobility ;

    @Enumerated(EnumType.STRING)
    private FamilySituation familySituation ;

    @Enumerated(EnumType.STRING)
    private MillitaryStatus milltarySituation ;

    private Boolean deviceEligibilty ;
    private String description ;
    private Boolean nightWork ;
    private Boolean teamWork ;
    private int residencyCity ;
    private Boolean accomodation ;
    private Boolean transport ;
    private Boolean restauration ;
    private int salary ;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idEmployer", nullable = false)
    private Employer employer;
}