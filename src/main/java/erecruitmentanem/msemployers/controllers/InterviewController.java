package erecruitmentanem.msemployers.controllers;

import erecruitmentanem.msemployers.entities.Interview;
import erecruitmentanem.msemployers.services.InterviewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("interviews")
@CrossOrigin(origins = "*")
public class InterviewController {
    @Autowired
    InterviewsService interviewsService;

    @PostMapping("/{idJobSeeker}/{idJobOffer}/{idEmployer}")
    ResponseEntity<Object> createApplication(@RequestBody Interview body, @PathVariable Long idJobSeeker, @PathVariable Long idJobOffer,@PathVariable Long idEmployer ){
        return interviewsService.createInterview(body,idJobSeeker,idJobOffer,idEmployer);
    }

    @GetMapping("/{idInterview}")
    ResponseEntity<Object> getInterviewById(@PathVariable Long idInterview ){
        return interviewsService.getInterviewById(idInterview);
    }

    @GetMapping("/b/{idJobOffer}")
    ResponseEntity<Object> getInterviewByIdJobOffer(@PathVariable Long idJobOffer ){
        return interviewsService.getInterviewByIdJobOffer(idJobOffer);
    }
    @GetMapping("/c/{idJobSeeker}")
    ResponseEntity<Object> getInterviewByIdJobSeeker(@PathVariable Long idJobSeeker ){
        return interviewsService.getInterviewByIdJobSeeker(idJobSeeker);
    }
    @GetMapping("/d/{idEmployer}")
    ResponseEntity<Object> getInterviewByIdEmployer(@PathVariable Long idEmployer ){
        return interviewsService.getInterviewByIdEmployer(idEmployer);
    }

    @GetMapping("/{idJobOffer}/{idJobSeeker}")
    ResponseEntity<Object> getInterviewByIdJobOfferAndIdJobSeeker(@PathVariable Long idJobSeeker,@PathVariable Long idJobOffer ){
        return interviewsService.getInterviewByIdJobOfferAndIdJobSeeker(idJobOffer,idJobSeeker);
    }


}
