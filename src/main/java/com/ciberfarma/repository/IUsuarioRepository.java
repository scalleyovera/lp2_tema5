package com.ciberfarma.repository;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.ciberfarma.model.Usuario;

public interface IUsuarioRepository extends JpaRepository<Usuario, Integer> {

	Usuario findByCorreoAndClave(String correo, String clave);
	
	Optional<Usuario>findByCorreo(String correo);

	boolean existsByCorreo(String correo);

}
