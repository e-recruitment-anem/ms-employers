package erecruitmentanem.msemployers.repositories;

import erecruitmentanem.msemployers.entities.Application;
import erecruitmentanem.msemployers.entities.Interview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface InterviewRepository extends JpaRepository<Interview,Long>, JpaSpecificationExecutor<Interview> {
    List<Interview> findInterviewsByIdJobOffer(Long idJobOffer);
    List<Interview> findInterviewsByIdJobSeeker(Long idJobSeeker);
    List<Interview> findInterviewsByIdEmployer(Long idEmployer);
    Interview findInterviewsByIdJobSeekerAndIdJobOffer(Long idJobSeeker,Long idJobOffer);
}