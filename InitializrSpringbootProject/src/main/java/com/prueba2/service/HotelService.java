package com.prueba2.service;

import com.prueba2.domain.Hotel;
import java.util.List;

public interface HotelService {
    
    public List<Hotel> getHoteles(String ubicacion);

    public Hotel getHotel(Hotel hotel);
    
    public void save(Hotel hotel);

    public void delete(Hotel hotel);
    
}
