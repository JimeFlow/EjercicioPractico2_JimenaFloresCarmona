package com.prueba2.controller;

import com.prueba2.domain.Reserva;
import com.prueba2.service.HotelService;
import com.prueba2.service.ReservaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    @Autowired
    private ReservaService reservaService;

    @Autowired
    private HotelService hotelService;

    @GetMapping("/listado")
    public String listaReservas(Model model) {
        int idReserva = 0;
        var reservas = reservaService.getReservas(idReserva);
        model.addAttribute("reservas", reservas);
        
        String ubicacion = null;
        var hoteles = hotelService.getHoteles(ubicacion);
        model.addAttribute("hoteles", hoteles);
        
        model.addAttribute("totalReservas", reservas.size());
        return "/reserva/listado";
    }
    
    @GetMapping("/nueva")
    public String reservaNueva(Reserva reserva) {
        return "/reserva/modifica";
    }
    
    @PostMapping("/guardar")
    public String reservaGuardar(Reserva reserva) {
        reservaService.save(reserva);
        return "redirect:/reservas/listado";
    }

    @GetMapping("/eliminar/{idReserva}")
    public String reservaEliminar(Reserva reserva) {
        reservaService.delete(reserva);
        return "redirect:/reserva/listado";
    }

    @GetMapping("/modificar/{idReserva}")
    public String reservaModificar(Reserva reserva, Model model) {
        reserva = reservaService.getReserva(reserva);
        model.addAttribute("reserva", reserva);
        
        String ubicacion = null;
        var hoteles = hotelService.getHoteles(ubicacion);
        model.addAttribute("hoteles", hoteles);
        
        return "/reserva/modifica";
    }   

}
