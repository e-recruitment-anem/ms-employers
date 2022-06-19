package erecruitmentanem.msemployers.repositories;

import erecruitmentanem.msemployers.entities.Application;
import erecruitmentanem.msemployers.entities.Employer;
import erecruitmentanem.msemployers.entities.JobOffer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface ApplicationRepository extends JpaRepository<Application,Long>, JpaSpecificationExecutor<Application> {
    List<Application> findApplicationsByIdJobOffer(Long idJobOffer);
    List<Application> findApplicationsByIdJobSeeker(Long idJobSeeker);

}
