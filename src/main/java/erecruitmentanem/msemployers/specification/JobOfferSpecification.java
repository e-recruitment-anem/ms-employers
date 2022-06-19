package erecruitmentanem.msemployers.specification;

import erecruitmentanem.msemployers.entities.JobOffer;
        import org.springframework.data.jpa.domain.Specification;
        import org.springframework.stereotype.Component;
        import javax.persistence.criteria.Predicate;
        import java.util.ArrayList;
        import java.util.List;

@Component
public class JobOfferSpecification {
    public Specification<JobOffer> getJobOffer(JobOffer request) {
        return (root, query, criteriaBuilder) -> {

            List<Predicate> predicates = new ArrayList<>();
            if (request.getAgency() != 0 ) {
                predicates.add(criteriaBuilder.equal(root.get("agency"),request.getAgency()));
            }
            if (request.getTitle() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("title"), request.getTitle()));
            }
            if (request.getContractType() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("contractType"), request.getContractType()));
            }
            if (request.getWorkAddress() != null ) {
                predicates.add(criteriaBuilder.equal(root.get("workAddress"), request.getWorkAddress()));
            }
            if (request.getJobTitle() != 0 ) {
                predicates.add(criteriaBuilder.equal(root.get("jobTitle"),request.getJobTitle()));
            }

            query.orderBy(criteriaBuilder.desc(root.get("title")));
            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

}