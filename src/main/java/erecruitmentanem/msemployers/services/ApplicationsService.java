package erecruitmentanem.msemployers.services;

import erecruitmentanem.msemployers.entities.Application;
import erecruitmentanem.msemployers.entities.JobOffer;
import erecruitmentanem.msemployers.helpers.ExceptionsHandler;
import erecruitmentanem.msemployers.helpers.ResponseHandler;
import erecruitmentanem.msemployers.repositories.ApplicationRepository;
import erecruitmentanem.msemployers.repositories.JobOfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ApplicationsService {

    @Autowired
    ApplicationRepository applicationRepository;

    @Autowired
    JobOfferRepository jobOfferRepository;

    public ResponseEntity<Object> createApplication(Application body,Long idJobSeeker,Long idJobOffer){
        try {
            Application  application = new Application();

            application.setLetter(body.getLetter());
            application.setDate(body.getDate());
            application.setStatus(body.getStatus());
            application.setIdJobSeeker(idJobSeeker);
            application.setIdJobOffer(idJobOffer);
            applicationRepository.save(application);
            return ResponseHandler.generateResponse("Application Created.", application);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getApplicationByIdJobOffer(Long idJobOffer){
        try {
            List<Application> applications =  applicationRepository.findApplicationsByIdJobOffer(idJobOffer);
            return ResponseHandler.generateResponse("Application found.", applications);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getApplicationByIdJobSeeker(Long idJobSeeker){
        try {
            List<Application> applications =  applicationRepository.findApplicationsByIdJobSeeker(idJobSeeker);
            return ResponseHandler.generateResponse("Application found.", applications);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getApplicationById(Long idApplication){
        try {

            if(applicationRepository.existsById(idApplication) == false){
                return ExceptionsHandler.itemNotFoundException();
            }
            Application application =  applicationRepository.findById(idApplication).get();
            return ResponseHandler.generateResponse("Application found.", application);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

}
