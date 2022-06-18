package erecruitmentanem.msemployers.controllers;
import erecruitmentanem.msemployers.entities.JobOffer;
import erecruitmentanem.msemployers.helpers.ExceptionsHandler;
import erecruitmentanem.msemployers.repositories.EmployerRepository;
import erecruitmentanem.msemployers.services.JobOffersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/job-offers")
@CrossOrigin(origins = "*")
public class JobOfferController {

    @Autowired
    JobOffersService jobOffersService ;

    @Autowired
    EmployerRepository employerRepository ;

    @PostMapping("/{idEmployer}")
    ResponseEntity<Object> createJobOffer(@RequestBody JobOffer body,@PathVariable Long idEmployer){
        if(employerRepository.existsById(idEmployer) == false){
            return ExceptionsHandler.itemNotFoundException();
        }
        return jobOffersService.createJobOffer(body, idEmployer);
    }

    @GetMapping("/{idEmployer}")
    ResponseEntity<Object> getJobOfferById(@PathVariable Long idEmployer){
        return jobOffersService.getJobOfferById(idEmployer);
    }

    @GetMapping("/b/{idEmployer}")
    ResponseEntity<Object> getJobOfferByEmployerId(@PathVariable Long idEmployer){
        return jobOffersService.getJobOfferByEmployerId(idEmployer);
    }

    @DeleteMapping("/{idEmployer}")
    ResponseEntity<Object> deleteEmployer(@PathVariable Long idEmployer){
        return jobOffersService.deleteJobOffer(idEmployer);
    }

    @PatchMapping("/{idEmployer}")
    ResponseEntity<Object> updateEmployer(@RequestBody JobOffer body , @PathVariable Long employerId){
        return jobOffersService.updateJobOffer(body, employerId);
    }

}