package com.api.Service;

import com.api.entity.Registration;
import com.api.exception.ResourceNotFoundExeption;
import com.api.payload.RegistrationDto;
import com.api.repository.RegistrationRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {
    private RegistrationRepository registrationRepository;

    //contractor based injection also use @Autowired
    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<Registration> getRegistration() {
        List<Registration> registrations = registrationRepository.findAll();
        return registrations;
    }

    //        public Registration createRegistration(Registration registration) {
//        Registration savedEntity = registrationRepository.save(registration);
//        return savedEntity;
//    }
//    Dto
    public RegistrationDto createRegistration(RegistrationDto registrationDto) {

       Registration registration= mapToEntity(registrationDto);
//        Registration registration =new Registration();
//        registration.setName(registrationDto.getName());
//        registration.setMobile(registrationDto.getMobile());
//        registration.setEmail(registrationDto.getEmail());
        
        Registration savedEntity = registrationRepository.save(registration);
        RegistrationDto dto = mapToDto(savedEntity);
//        RegistrationDto dto = new RegistrationDto();
//        dto.setName(savedEntity.getName());
//        dto.setEmail(savedEntity.getEmail());
//        dto.setMobile(savedEntity.getMobile());
        return dto;
    }

        public void deleteRegistration ( long id){
            registrationRepository.deleteById(id);
        }

        public Registration updateRegistration(long id, Registration registration) {
            Registration r = registrationRepository.findById(id).get();
            r.setName(registration.getName());
            r.setEmail(registration.getEmail());
            r.setMobile(registration.getMobile());
            Registration savedEntity = registrationRepository.save(r);
            return savedEntity;

        }
        // convert Dto to Entity
            Registration mapToEntity(RegistrationDto registrationDto){
                Registration registration =new Registration();
                registration.setName(registrationDto.getName());
                registration.setMobile(registrationDto.getMobile());
                registration.setEmail(registrationDto.getEmail());
                return  registration;
            }
            //convert Entity to Dto
            RegistrationDto mapToDto(Registration registration){
             RegistrationDto dto = new RegistrationDto();
                dto.setName(registration.getName());
                dto.setEmail(registration.getEmail());
                dto.setMobile(registration.getMobile());
                return dto;
            }

    public RegistrationDto getRegistrationById(long id) {
        Registration registration = registrationRepository.findById(id).orElseThrow(
                ()->new ResourceNotFoundExeption("Record not found")
        );
        return mapToDto(registration);
    }
}

