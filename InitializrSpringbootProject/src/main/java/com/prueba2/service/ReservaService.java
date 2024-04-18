package com.prueba2.service;

import com.prueba2.domain.Reserva;
import java.util.Date;
import java.util.List;

public interface ReservaService {

    public List<Reserva> getReservas(int idReserva);

    public Reserva getReserva(Reserva reserva);

    public void save(Reserva reserva);

    public void delete(Reserva reserva);

    public List<Reserva> findByFechaIngresoBetweenOrderByDescripcion(Date fechaIngresoInf, Date fechaIngresoSup);

    public List<Reserva> metodoJPQL(Date fechaIngresoInf, Date fechaIngresoSup);

    public List<Reserva> metodoNativo(Date fechaIngresoInf, Date fechaIngresoSup);

}
