package erecruitmentanem.msemployers.controllers;

import erecruitmentanem.msemployers.entities.Application;
import erecruitmentanem.msemployers.services.ApplicationsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("applications")
@CrossOrigin(origins = "*")
public class ApplicationController {

    @Autowired
    ApplicationsService applicationsService;

    @PostMapping("/{idJobSeeker}/{idJobOffer}")
    ResponseEntity<Object> createApplication(@RequestBody Application body,@PathVariable Long idJobSeeker,@PathVariable Long idJobOffer ){
        return applicationsService.createApplication(body,idJobSeeker,idJobOffer);
    }

    @GetMapping("/{idApplication}")
    ResponseEntity<Object> getApplicationById(@PathVariable Long idApplication ){
        return applicationsService.getApplicationById(idApplication);
    }

    @GetMapping("/b/{idJobOffer}")
    ResponseEntity<Object> getApplicationByIdJobOffer(@PathVariable Long idJobOffer ){
        return applicationsService.getApplicationByIdJobOffer(idJobOffer);
    }

    @GetMapping("/c/{idJobSeeker}")
    ResponseEntity<Object> getApplicationByIdJobSeeker(@PathVariable Long idJobSeeker ){
        return applicationsService.getApplicationByIdJobSeeker(idJobSeeker);
    }


}
