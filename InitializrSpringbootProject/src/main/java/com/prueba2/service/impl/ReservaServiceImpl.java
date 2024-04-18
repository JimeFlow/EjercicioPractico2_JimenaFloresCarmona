package com.prueba2.service.impl;

import com.prueba2.dao.ReservaDao;
import com.prueba2.domain.Reserva;
import com.prueba2.service.ReservaService;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReservaServiceImpl implements ReservaService {
    
    @Autowired
    private ReservaDao reservaDao;
    
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> getReservas(int idReserva) {
        var lista = reservaDao.findAll();
        return lista;
    }

    @Override
    @Transactional(readOnly = true)
    public Reserva getReserva(Reserva reserva) {
        return reservaDao.findById(reserva.getIdReserva()).orElse(null);
    }

    @Override
    @Transactional
    public void save(Reserva reserva) {
        reservaDao.save(reserva);
    }

    @Override
    @Transactional
    public void delete(Reserva reserva) {
        reservaDao.delete(reserva);
    }
    
    @Override
    @Transactional(readOnly = true)
    public List<Reserva> findByFechaIngresoBetweenOrderByDescripcion(Date fechaIngresoInf, Date fechaIngresoSup) {
        return reservaDao.findByFechaIngresoBetweenOrderByDescripcion(fechaIngresoInf, fechaIngresoSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> metodoJPQL(Date fechaIngresoInf, Date fechaIngresoSup) {
        return reservaDao.metodoJPQL(fechaIngresoInf, fechaIngresoSup);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Reserva> metodoNativo(Date fechaIngresoInf, Date fechaIngresoSup) {
        return reservaDao.metodoNativo(fechaIngresoInf, fechaIngresoSup);
    }
    
}
