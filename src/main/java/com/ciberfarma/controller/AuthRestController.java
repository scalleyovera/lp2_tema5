package com.ciberfarma.controller;

import com.ciberfarma.dto.LoginUserDto;
import com.ciberfarma.dto.NewUserDto;
import com.ciberfarma.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/authentication")
public class AuthRestController {

	private final AuthService authService;

	@Autowired
	public AuthRestController(AuthService authService){
		this.authService = authService;
	}

	@PostMapping("/login")
	public ResponseEntity<String> login(@RequestBody LoginUserDto loginUserDto) {
		try {
			String jwt = authService.authenticate(loginUserDto.getCorreo(), loginUserDto.getClave());
			return ResponseEntity.ok(jwt);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body("Revise sus credenciales");
		}
	}

	@PostMapping("/register")
	public ResponseEntity<String> register(@RequestBody NewUserDto newUserDto) {
		try {
			authService.registerUser(newUserDto);
			return ResponseEntity.status(HttpStatus.CREATED).body("Usuario registrado exitosamente.");
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
}
