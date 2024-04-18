package com.prueba2.dao;

import com.prueba2.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioDao extends JpaRepository <Usuario, String> {
    
    Usuario findByUsername(String username);
    Usuario findByUsernameAndPassword(String username, String Password);
    Usuario findByUsernameOrCorreo(String username, String Correo);
    boolean existsByUsernameOrCorreo(String username, String Correo);
    
}