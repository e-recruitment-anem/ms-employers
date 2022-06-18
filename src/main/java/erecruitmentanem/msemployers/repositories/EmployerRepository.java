package erecruitmentanem.msemployers.repositories;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import erecruitmentanem.msemployers.entities.Employer;


public interface EmployerRepository extends JpaRepository<Employer,Long>, JpaSpecificationExecutor<Employer> {
}
