package tech.klok.kear.hub.application.adesao.service;

import org.springframework.amqp.core.ReceiveAndReplyCallback;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tech.klok.kear.hub.infrastructure.rabbitMQ.MQConfig;
import tech.klok.kear.hub.infrastructure.security.auth.JwtUtils;
import tech.klok.kear.hub.infrastructure.security.service.UserSecurityService;
import tech.klok.kear.hub.presentation.authentication.dto.CredentialsDTO;
import tech.klok.kear.hub.presentation.login.dto.LoginResponseDTO;

@Service
public class LoginService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserSecurityService userService;

    @Autowired
    private JwtUtils jwtUtils;
    
    public LoginResponseDTO fazerLogin(CredentialsDTO credentials) throws Exception {
        String username = credentials.getUserName();
        String password = credentials.getPassword();

        try {
            authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        } catch (Exception e) {
            throw new Exception("Erro na autenticação " + credentials.getUserName());
        }

        UserDetails loadedUser = userService.loadUserByUsername(username);

        String generatedToken = jwtUtils.generateToken(loadedUser);

        LoginResponseDTO responseDTO = new LoginResponseDTO();
        responseDTO.setResponse(generatedToken);
        return responseDTO;
        
    }
}
