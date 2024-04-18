package com.prueba2.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.List;
import lombok.Data;

@Data
@Entity
@Table(name = "hoteles")

public class Hotel implements Serializable {
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_hotel")
    private int idHotel;
    private String nombre;
    private String ubicacion;
    private String descripcion;
    
    @OneToMany
    @JoinColumn(name = "id_hotel", updatable = false)
    List<Reserva> reservas;

    public Hotel(int idHotel, String nombre, String ubicacion, String descripcion) {
        this.idHotel = idHotel;
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
    }

}