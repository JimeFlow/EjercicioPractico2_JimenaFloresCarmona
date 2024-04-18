package com.prueba2.dao;

import com.prueba2.domain.Rol;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolDao extends JpaRepository <Rol, Integer> {
    
}