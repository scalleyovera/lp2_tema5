package com.ciberfarma.services;

import com.ciberfarma.dto.NewUserDto;
import com.ciberfarma.model.Usuario;
import com.ciberfarma.utils.JwtUtil;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final JwtUtil jwtUtil;
    private final AuthenticationManagerBuilder authenticationManagerBuilder;

    public AuthService(UserService userService,
                       PasswordEncoder passwordEncoder,
                       JwtUtil jwtUtil,
                       AuthenticationManagerBuilder authenticationManagerBuilder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.jwtUtil = jwtUtil;
        this.authenticationManagerBuilder = authenticationManagerBuilder;
    }

    public String authenticate(String correo, String clave) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(correo, clave);

        Authentication authResult = authenticationManagerBuilder
                .getObject()
                .authenticate(authenticationToken);

        SecurityContextHolder.getContext().setAuthentication(authResult);

        return jwtUtil.generateToken(authResult);
    }

    public void registerUser(NewUserDto newUserDto) {
        if (userService.existsByCorreo(newUserDto.getCorreo())) {
            throw new IllegalArgumentException("Este correo ya existe.");
        }

        Usuario _usuario = new Usuario(
                newUserDto.getNom_usua(),
                newUserDto.getApe_usua(),
                newUserDto.getCorreo(),
                passwordEncoder.encode(newUserDto.getClave())
        );

        userService.save(_usuario);
    }
}
