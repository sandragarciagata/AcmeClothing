package com.sgg.AcmeClothingApp.services;

import com.sgg.AcmeClothingApp.models.Prendas;
import com.sgg.AcmeClothingApp.repositories.PrendasRepository;
import java.util.ArrayList;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public class PrendasServices {

    @Autowired
    PrendasRepository prendasRepository;

    // Metodo para recuperar todas las prendas
    public ArrayList<Prendas> obtenerPrendas() {
        return (ArrayList<Prendas>) prendasRepository.findAll();
    }

    // Metodo para buscar por id
    // Optional para evitar que cause error si no existe
    public Optional<Prendas> obtenerPorId(String prendaId) {
        return prendasRepository.findById(prendaId);
    }

    // Metodo para buscar por categoria
    public ArrayList<Prendas> obtenerPorCategoria(String categoria) {
        return prendasRepository.obtenerPorCategoria(categoria);
    }

    // Metodo para guardar prendas
    public void guardarPrendas(Prendas prenda) {
        prendasRepository.save(prenda);
    }
   
    // Metodo para eliminar pod id
    public boolean eliminarPrenda(String prendaId) {
        try {
            prendasRepository.deleteById(prendaId);
            return true;
        } catch(Exception exception) {
            return false;
        }
    }

    
}
