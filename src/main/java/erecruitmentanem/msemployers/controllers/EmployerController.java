package erecruitmentanem.msemployers.controllers;
import erecruitmentanem.msemployers.services.EmployersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import erecruitmentanem.msemployers.entities.Employer ;

@RestController
@RequestMapping("employers")
@CrossOrigin(origins = "*")
public class EmployerController {

    @Autowired
    EmployersService employersService ;

    @PostMapping("create")
    ResponseEntity<Object> createEmployer(@RequestBody Employer body){
        return employersService.createEmployer(body);
    }

    @GetMapping("/{idEmployer}")
    ResponseEntity<Object> getEmployerById(@PathVariable Long idEmployer){
        return employersService.getEmployerById(idEmployer);
    }

    @DeleteMapping("/{idEmployer}")
    ResponseEntity<Object> deleteEmployer(@PathVariable Long idEmployer){
        return employersService.deleteEmployer(idEmployer);
    }

    @PatchMapping("/{idEmployer}")
    ResponseEntity<Object> updateEmployer(@RequestBody Employer body , @PathVariable Long idEmployer){
        return employersService.updateEmployer(body, idEmployer);
    }

}
