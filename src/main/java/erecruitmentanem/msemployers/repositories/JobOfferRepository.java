package erecruitmentanem.msemployers.repositories;

import erecruitmentanem.msemployers.entities.JobOffer;
import erecruitmentanem.msemployers.entities.Employer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import java.util.List;

public interface JobOfferRepository extends JpaRepository<JobOffer,Long>, JpaSpecificationExecutor<JobOffer> {

    Page<JobOffer> findAll(Specification<JobOffer> spec, Pageable pageable);
    List<JobOffer> findAll(Specification<JobOffer> spec);
    List<JobOffer> findAllByEmployer(Employer employer);
}
