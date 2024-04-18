package com.prueba2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.io.Serializable;
import java.util.Date;
import lombok.Data;

@Data
@Entity
@Table(name = "reservas")
public class Reserva implements Serializable {
    
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_reserva")
    private int idReserva;
    private String clienteNombre;
    private int numHuespedes;
    private Date fechaIngreso;
    private Date fechaSalida;
    
    @ManyToOne
    @JoinColumn(name = "hotel_id")
    Hotel hotel;

    @ManyToOne
    @JoinColumn(name = "numero_cedula")
    Usuario usuario;

    public Reserva(int idReserva, String clienteNombre, int numHuespedes, Date fechaIngreso, Date fechaSalida) {
        this.idReserva = idReserva;
        this.clienteNombre = clienteNombre;
        this.numHuespedes = numHuespedes;
        this.fechaIngreso = fechaIngreso;
        this.fechaSalida = fechaSalida;
    }
    
}
