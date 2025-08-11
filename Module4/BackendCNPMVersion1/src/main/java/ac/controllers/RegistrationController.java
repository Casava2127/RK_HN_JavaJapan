package ac.controllers;

import ac.models.Registration;
import ac.repositories.RegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/registration")
public class RegistrationController {

    @Autowired
    private RegistrationRepository registrationRepository;

    @PostMapping
    public ResponseEntity<?> registerUser(@RequestBody Registration registration) {
        try {
            Registration savedRegistration = registrationRepository.save(registration);
            return ResponseEntity.status(201).body(savedRegistration);
        } catch (Exception e) {
            return ResponseEntity.status(500).body("An error occurred during registration");
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getRegistration(@PathVariable Long id) {
        return registrationRepository.findById(id)
                .map(registration -> ResponseEntity.ok(registration))
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateRegistration(@PathVariable Long id, @RequestBody Registration registrationDetails) {
        return registrationRepository.findById(id)
                .map(registration -> {
                    registration.setName(registrationDetails.getName());
                    registration.setEmail(registrationDetails.getEmail());
                    // Update other fields as necessary
                    Registration updatedRegistration = registrationRepository.save(registration);
                    return ResponseEntity.ok(updatedRegistration);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteRegistration(@PathVariable Long id) {
        return registrationRepository.findById(id)
                .map(registration -> {
                    registrationRepository.delete(registration);
                    return ResponseEntity.ok().build();
                })
                .orElse(ResponseEntity.notFound().build());
    }
}