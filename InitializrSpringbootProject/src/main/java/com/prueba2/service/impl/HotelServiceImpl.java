package com.prueba2.service.impl;

import com.prueba2.dao.HotelDao;
import com.prueba2.domain.Hotel;
import com.prueba2.service.HotelService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class HotelServiceImpl implements HotelService{
    
    @Autowired
    private HotelDao hotelDao;

    @Override
    @Transactional(readOnly = true)
    public List<Hotel> getHoteles(String ubicacion) {
        var lista = hotelDao.findAll();
        return lista;
    }

    @Override
    public Hotel getHotel(Hotel hotel) {
        return hotelDao.findById(hotel.getIdHotel()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Hotel hotel) {
        hotelDao.save(hotel);
    }

    @Override
    @Transactional
    public void delete(Hotel hotel) {
        hotelDao.delete(hotel);
    }
    
}
