package med.voll.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import med.voll.api.infra.security.DataTokenJWT;
import med.voll.api.infra.security.TokenService;
import med.voll.api.model.person.DataAutowired;
import med.voll.api.model.person.User;

@RestController
@RequestMapping("/login")
public class UserController {

        @Autowired
        private AuthenticationManager manager;

        @Autowired
        private TokenService tokenService;

        @PostMapping
        public ResponseEntity<Object> initSession(@RequestBody @Valid DataAutowired data) {
                try {
                        var token = new UsernamePasswordAuthenticationToken(
                                        data.login(),
                                        data.psw());
                        var authentication = manager.authenticate(token);
                        var tokenJWT = tokenService.createToken(
                                        (User) authentication.getPrincipal());
                        return ResponseEntity.ok(new DataTokenJWT(
                                        tokenJWT));
                } catch (Exception e) {
                        e.printStackTrace();
                        return ResponseEntity.badRequest().body(e.getMessage());
                }
        }
}
