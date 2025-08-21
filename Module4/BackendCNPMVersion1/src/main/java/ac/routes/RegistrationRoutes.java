package ac.routes;

import ac.controllers.RegistrationController;
import ac.dtos.RegistrationRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Configuration
@RestController
@RequestMapping("/api/registration")
public class RegistrationRoutes {

    @Autowired
    private RegistrationController registrationController;

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody RegistrationRequest registrationRequest) {
        return registrationController.registerUser(registrationRequest);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody LoginRequest loginRequest) {
        return registrationController.loginUser(loginRequest);
    }
}