package tech.klok.kear.hub.application.adesao.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.klok.kear.hub.application.adesao.service.LoginService;
import tech.klok.kear.hub.presentation.authentication.dto.CredentialsDTO;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody CredentialsDTO credentials) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(loginService.fazerLogin(credentials));
        } catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
