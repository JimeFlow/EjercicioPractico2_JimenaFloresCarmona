package com.prueba2.controller;

import com.prueba2.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/hotel")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @GetMapping("/hoteles")
    public String listaHoteles(Model model) {
        String ubicacion = null;
        var hoteles = hotelService.getHoteles(ubicacion);
        model.addAttribute("hoteles", hoteles);
        return "hoteles/listado";
    }

}
