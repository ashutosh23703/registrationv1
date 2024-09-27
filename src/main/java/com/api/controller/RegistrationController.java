package com.api.controller;

import com.api.Service.RegistrationService;
import com.api.entity.Registration;
import com.api.payload.RegistrationDto;
import jakarta.validation.Valid;
import org.apache.coyote.Request;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;   
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }


    @GetMapping
    public ResponseEntity<List<Registration>> getRegistrations() {
        List<Registration> registration = registrationService.getRegistration();
        return new ResponseEntity<>(registration, HttpStatus.OK);

    }

    //    @PostMapping
//    public ResponseEntity<Registration> createRegistration(
//         @RequestBody Registration registration
//    ){
//        Registration reg = registrationService.createRegistration(registration);
//        return  new ResponseEntity<>(reg, HttpStatus.CREATED);
//    }
    @PostMapping
    public ResponseEntity<?> createRegistration(
            @Valid @RequestBody RegistrationDto registrationDto,
            BindingResult result  //vaildation Error

    ) {
        if (result.hasErrors()){
            return new ResponseEntity<>(result.getFieldError().getDefaultMessage(), HttpStatus.CREATED);
        }
        RegistrationDto regDto = registrationService.createRegistration(registrationDto);
        return new ResponseEntity<>(regDto, HttpStatus.CREATED);
    }

    @DeleteMapping
    public ResponseEntity<String> deleteRegistration(
            @RequestParam long id
    ) {
        registrationService.deleteRegistration(id);
        return new ResponseEntity<>("Deleted", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Registration> updateregistration(
            @PathVariable long id,
            @RequestBody Registration registration

    ) {
        Registration updateReg = registrationService.updateRegistration(id, registration);
        return new ResponseEntity<>(updateReg, HttpStatus.OK);
    }
// for Exception Handling
    @GetMapping("/{id}")
    public ResponseEntity<RegistrationDto> getRegistrationById(
            @PathVariable long id
    ) {

        RegistrationDto dto = registrationService.getRegistrationById(id);
        return new ResponseEntity<>(dto, HttpStatus.OK);

    }
}