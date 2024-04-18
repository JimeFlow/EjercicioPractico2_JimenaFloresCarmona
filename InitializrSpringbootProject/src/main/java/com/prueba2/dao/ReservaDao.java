package com.prueba2.dao;


import com.prueba2.domain.Reserva;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ReservaDao extends JpaRepository<Reserva, Integer> {
    
    public List<Reserva> findByFechaIngresoBetweenOrderByDescripcion(Date fechaIngresoInf, Date fechaIngresoSup);

    @Query(value = "SELECT r FROM Reserva r WHERE r.fechaIngreso BETWEEN :fechaIngresoInf AND :fechaIngresoSup ORDER BY r.descripcion ASC")
    public List<Reserva> metodoJPQL(@Param("fechaIngresoInf") Date fechaIngresoInf, @Param("fechaIngresoSup") Date fechaIngresoSup);

    @Query(nativeQuery = true,
            value = "SELECT * FROM reserva WHERE reserva.fecha_ingreso BETWEEN :fechaIngresoInf AND :fechaIngresoSup ORDER BY reserva.descripcion ASC")
    public List<Reserva> metodoNativo(@Param("fechaIngresoInf") Date fechaIngresoInf, @Param("fechaIngresoSup") Date fechaIngresoSup);

}