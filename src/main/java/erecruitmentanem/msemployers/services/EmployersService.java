package erecruitmentanem.msemployers.services;

import erecruitmentanem.msemployers.entities.Employer;
import erecruitmentanem.msemployers.helpers.ExceptionsHandler;
import erecruitmentanem.msemployers.helpers.ResponseHandler;
import erecruitmentanem.msemployers.repositories.EmployerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class EmployersService {

    @Autowired
    EmployerRepository employerRepository;


    public ResponseEntity<Object> createEmployer(Employer body){
        try {
            Employer employer = new Employer();

            employer.setIdAccount(body.getIdAccount());
            employer.setName(body.getName());
            employer.setAgency(body.getAgency());
            employer.setRegistrationDate(body.getRegistrationDate());
            employer.setSocialRaison(body.getSocialRaison());
            employer.setMainActivity(body.getMainActivity());
            employer.setSecondaryActivity(body.getSecondaryActivity());
            employer.setLegalSector(body.getLegalSector());
            employer.setLegalStatus(body.getLegalStatus());
            employer.setActivityBranch(body.getActivityBranch());
            employer.setActivitySector(body.getActivitySector());
            employer.setCommercialRegisterNumber(body.getCommercialRegisterNumber());
            employerRepository.save(employer);
            return ResponseHandler.generateResponse("Employer Created.", employer);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }


    public ResponseEntity<Object> getEmployerById(Long employerId){
        try {
            Employer employer = employerRepository.findById(employerId).get();
            return ResponseHandler.generateResponse("Employer found.", employer);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }


    public ResponseEntity<Object> updateEmployer(Employer body , Long employerId){
        try {
            Employer employer = employerRepository.findById(employerId).get() ;
            employer.setIdAccount(body.getIdAccount());
            employer.setName(body.getName());
            employer.setAgency(body.getAgency());
            employer.setRegistrationDate(body.getRegistrationDate());
            employer.setSocialRaison(body.getSocialRaison());
            employer.setMainActivity(body.getMainActivity());
            employer.setSecondaryActivity(body.getSecondaryActivity());
            employer.setLegalSector(body.getLegalSector());
            employer.setLegalStatus(body.getLegalStatus());
            employer.setActivityBranch(body.getActivityBranch());
            employer.setActivitySector(body.getActivitySector());
            employer.setCommercialRegisterNumber(body.getCommercialRegisterNumber());
            employerRepository.save(employer);
            return ResponseHandler.generateResponse("Employer updated.", employer);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> deleteEmployer(Long employerId){
        try {

            employerRepository.deleteById(employerId);
            return ResponseHandler.generateResponse("Employer deleted.", null);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }


}
