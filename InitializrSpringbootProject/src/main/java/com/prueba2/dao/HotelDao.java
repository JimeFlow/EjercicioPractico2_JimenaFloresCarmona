package com.prueba2.dao;

import com.prueba2.domain.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelDao extends JpaRepository <Hotel, Integer> {
    
}
