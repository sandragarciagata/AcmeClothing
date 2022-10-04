package com.sgg.AcmeClothingApp.services;

import com.sgg.AcmeClothingApp.models.Promociones;
import com.sgg.AcmeClothingApp.repositories.PromocionesRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PromocionesServices {
    @Autowired
    PromocionesRepository promocionesRepository;

    // Metodo para recuperar todas las prendas
    public ArrayList<Promociones> obtenerPromociones() {
        return (ArrayList<Promociones>) promocionesRepository.findAll();
    }

    // Metodo para buscar por id
    // Optional para evitar que cause error si no existe
    public Optional<Promociones> obtenerPorId(String promoId) {
        return promocionesRepository.findById(promoId);
    }

    // Metodo para guardar prendas
    public void guardarPromocion(Promociones promocion) {
        promocionesRepository.save(promocion);
    }
   
    // Metodo para eliminar pod id
    public boolean eliminarPromocion(String promoId) {
        try {
            promocionesRepository.deleteById(promoId);
            return true;
        } catch(Exception exception) {
            return false;
        }
    }

}
