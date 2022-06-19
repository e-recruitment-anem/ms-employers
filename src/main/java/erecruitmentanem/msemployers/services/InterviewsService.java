package erecruitmentanem.msemployers.services;

import erecruitmentanem.msemployers.entities.Application;
import erecruitmentanem.msemployers.entities.Interview;
import erecruitmentanem.msemployers.helpers.ExceptionsHandler;
import erecruitmentanem.msemployers.helpers.ResponseHandler;
import erecruitmentanem.msemployers.repositories.InterviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterviewsService {

    @Autowired
    InterviewRepository interviewRepository ;

    public ResponseEntity<Object> createInterview(Interview body, Long idJobSeeker, Long idJobOffer, Long idEmployer){
        try {
            Interview  interview = new Interview();

            interview.setDate(body.getDate());
            interview.setDuration(body.getDuration());
            interview.setPlace(body.getPlace());
            interview.setOther(body.getOther());
            interview.setResult(body.getResult());
            interview.setStatus(body.getStatus());
            interview.setIdJobSeeker(idJobSeeker);
            interview.setIdJobOffer(idJobOffer);
            interview.setIdEmployer(idEmployer);

            interviewRepository.save(interview);
            return ResponseHandler.generateResponse("Interview Created.", interview);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getInterviewById(Long idInterview){
        try {

            Interview  interview = interviewRepository.findById(idInterview).get();
            return ResponseHandler.generateResponse("Interview found.", interview);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getInterviewByIdJobOffer(Long idJobOffer){
        try {

            List<Interview>  interview = interviewRepository.findInterviewsByIdJobOffer(idJobOffer);
            return ResponseHandler.generateResponse("Interview found.", interview);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getInterviewByIdJobSeeker(Long idJobOffer){
        try {

            List<Interview> interview = interviewRepository.findInterviewsByIdJobSeeker(idJobOffer);
            return ResponseHandler.generateResponse("Interview found.", interview);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getInterviewByIdEmployer(Long idJobOffer){
        try {

            List<Interview>  interview = interviewRepository.findInterviewsByIdEmployer(idJobOffer);
            return ResponseHandler.generateResponse("Interview found.", interview);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }

    public ResponseEntity<Object> getInterviewByIdJobOfferAndIdJobSeeker(Long idJobSeeker ,Long idJobOffer){
        try {

            Interview  interview = interviewRepository.findInterviewsByIdJobSeekerAndIdJobOffer(idJobSeeker,idJobOffer);
            return ResponseHandler.generateResponse("Interview found.", interview);
        } catch (Exception e) {
            System.out.println(e);
            return ExceptionsHandler.badRequestException();
        }
    }
}
