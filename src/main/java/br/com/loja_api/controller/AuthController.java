package br.com.loja_api.controller;

import java.util.Map;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.loja_api.entity.User;
import br.com.loja_api.repository.UserRepository;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    // Criar usuário
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody User user) {
        if (userRepository.findByUsername(user.getUsername()).isPresent()) {
            return ResponseEntity.badRequest().body("Usuário já existe");
        }
        userRepository.save(user);
        return ResponseEntity.ok("Usuário criado com sucesso");
    }

    // Login
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody User user) {
        Optional<User> encontrado = userRepository.findByUsername(user.getUsername());

        if (encontrado.isEmpty() || !encontrado.get().getPassword().equals(user.getPassword())) {
            return ResponseEntity.status(401).body("Usuário ou senha incorretos");
        }

        // Token simples por enquanto
        return ResponseEntity.ok(Map.of("token", "token-" + user.getUsername()));
    }
}
