package com.sgg.AcmeClothingApp.controllers;

import com.sgg.AcmeClothingApp.models.Prendas;
import com.sgg.AcmeClothingApp.services.PrendasServices;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/prendas")
public class PrendasController {

    @Autowired
    PrendasServices prendasServices;

    // Obtener Prendas y Prendas por Id
    @GetMapping( path = "/api/v1/prendas/{prendaId}")
    public ArrayList<Prendas> obtenerPrendas(@PathVariable("prendaId") String prendaId) {
        return this.prendasServices.obtenerPrendas();
    }

    // Obtener Prendas por categoria
    public ArrayList<Prendas> obtenerPorCategoria(@RequestParam("categoria") String categoria) {
        return this.prendasServices.obtenerPorCategoria(categoria);
    }
    
    // Guardar prenda
    @PostMapping( path = "/api/v1/prendas")
    public void guardarPrendas(@RequestBody Prendas prenda) {
       this.prendasServices.guardarPrendas(prenda);
    }
   
    @DeleteMapping( path = "/api/v1/prendas/{prendaId}")
    public String eliminarPorId(@PathVariable("prendaId") String prendaId) {
        boolean eliminada = this.prendasServices.eliminarPrenda(prendaId);
        if (eliminada) {
            return "La prenda con este id ha sido eliminada: " + prendaId;
        } else {
            return "La prenda con este id no fue eliminada: " + prendaId;
        }
        
    }
}
