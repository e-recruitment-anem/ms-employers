package erecruitmentanem.msemployers.services;

import erecruitmentanem.msemployers.entities.JobOffer;
import erecruitmentanem.msemployers.entities.Employer;
import erecruitmentanem.msemployers.helpers.ExceptionsHandler;
import erecruitmentanem.msemployers.helpers.ResponseHandler;
import erecruitmentanem.msemployers.repositories.EmployerRepository;
import erecruitmentanem.msemployers.repositories.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class JobOffersService {


     @Autowired
     JobOfferRepository jobOfferRepository ;

     @Autowired
     EmployerRepository employerRepository;

     public ResponseEntity<Object> createJobOffer(JobOffer body, Long employerId){
        try {
            if(employerRepository.existsById(employerId) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
            JobOffer jobOffer = new JobOffer();
            jobOffer.setEmployer(employerRepository.findById(employerId).get());

            //jobOffer.setIdJobOffer(body.getIdJobOffer());
            jobOffer.setAgency(body.getAgency());
            jobOffer.setTitle(body.getTitle());
            jobOffer.setPositionsNumber(body.getPositionsNumber());
            jobOffer.setAvaialablePositionsNumber(body.getAvaialablePositionsNumber());
            jobOffer.setJobTitle(body.getJobTitle());
            jobOffer.setWorkAddress(body.getWorkAddress());
            jobOffer.setMinAge(body.getMinAge());
            jobOffer.setMaxAge(body.getMaxAge());
            jobOffer.setGender(body.getGender());
            jobOffer.setContractType(body.getContractType());
            jobOffer.setClosedAt(body.getClosedAt());
            jobOffer.setDuration(body.getDuration());
            jobOffer.setQualificationLevel(body.getQualificationLevel());
            jobOffer.setEducationLevel(body.getEducationLevel());
            jobOffer.setMobility(body.getMobility());
            jobOffer.setFamilySituation(body.getFamilySituation());
            jobOffer.setMilltarySituation(body.getMilltarySituation());
            jobOffer.setDeviceEligibilty(body.getDeviceEligibilty());
            jobOffer.setDescription(body.getDescription());
            jobOffer.setNightWork(body.getNightWork());
            jobOffer.setTeamWork(body.getTeamWork());
            jobOffer.setResidencyCity(body.getResidencyCity());
            jobOffer.setAccomodation(body.getAccomodation());
            jobOffer.setTransport(body.getTransport());
            jobOffer.setRestauration(body.getRestauration());
            jobOffer.setSalary(body.getSalary());


            jobOfferRepository.save(jobOffer);
            return ResponseHandler.generateResponse("JobOffer Created.", jobOffer);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }


    public ResponseEntity<Object> getJobOfferById(Long jobOfferId){
        try {
            JobOffer jobOffer = jobOfferRepository.findById(jobOfferId).get();
            return ResponseHandler.generateResponse("JobOffer found.", jobOffer);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }


    public ResponseEntity<Object> updateJobOffer(JobOffer body, Long jobOfferId){
        try {
            JobOffer jobOffer = jobOfferRepository.findById(jobOfferId).get();
            jobOffer.setAgency(body.getAgency());
            jobOffer.setTitle(body.getTitle());
            jobOffer.setPositionsNumber(body.getPositionsNumber());
            jobOffer.setAvaialablePositionsNumber(body.getAvaialablePositionsNumber());
            jobOffer.setJobTitle(body.getJobTitle());
            jobOffer.setWorkAddress(body.getWorkAddress());
            jobOffer.setMinAge(body.getMinAge());
            jobOffer.setMaxAge(body.getMaxAge());
            jobOffer.setGender(body.getGender());
            jobOffer.setContractType(body.getContractType());
            jobOffer.setClosedAt(body.getClosedAt());
            jobOffer.setDuration(body.getDuration());
            jobOffer.setQualificationLevel(body.getQualificationLevel());
            jobOffer.setEducationLevel(body.getEducationLevel());
            jobOffer.setMobility(body.getMobility());
            jobOffer.setFamilySituation(body.getFamilySituation());
            jobOffer.setMilltarySituation(body.getMilltarySituation());
            jobOffer.setDeviceEligibilty(body.getDeviceEligibilty());
            jobOffer.setDescription(body.getDescription());
            jobOffer.setNightWork(body.getNightWork());
            jobOffer.setTeamWork(body.getTeamWork());
            jobOffer.setResidencyCity(body.getResidencyCity());
            jobOffer.setAccomodation(body.getAccomodation());
            jobOffer.setTransport(body.getTransport());
            jobOffer.setRestauration(body.getRestauration());
            jobOffer.setSalary(body.getSalary());
            jobOfferRepository.save(jobOffer);
            return ResponseHandler.generateResponse("JobOffer updated.", jobOffer);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> deleteJobOffer(Long jobOfferId){
        try {

            jobOfferRepository.deleteById(jobOfferId);
            return ResponseHandler.generateResponse("JobOffer deleted.", null);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getJobOfferByEmployerId(Long jobOfferId){
        try {
            Employer employer = employerRepository.findById(jobOfferId).get();
            List<JobOffer> jobOffers = jobOfferRepository.findAllByEmployer(employer) ;
            JobOffer jobOffer = jobOfferRepository.findById(jobOfferId).get();
            return ResponseHandler.generateResponse("JobOffer List found.", jobOffers);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

}
