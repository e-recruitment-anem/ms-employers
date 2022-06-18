package erecruitmentanem.msemployers.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;


@Entity
@Data
@NoArgsConstructor
@Table(name = "employers")
@AllArgsConstructor
public class Employer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idEmployer")
    private Long idEmployer ;

    private int idAccount ;
    private String name;
    private int agency;
    private int commercialRegisterNumber ;
    private Date registrationDate ;
    private int socialRaison ;
    private String mainActivity ;
    private String secondaryActivity ;
    private String legalSector ;
    private String legalStatus;
    private String activityBranch ;
    private String activitySector ;
    private String recruitmentResponsible;
    private String address ;
    private int state ;
    private String postalCode ;
    private int phoneNumber ;
    private String fax;
    private String email ;
    private String websiteUrl;

    @OneToMany(mappedBy = "employer", fetch = FetchType.LAZY,
            cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<JobOffer> jobOffer;
}
