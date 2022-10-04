package com.sgg.AcmeClothingApp.repositories;

import com.sgg.AcmeClothingApp.models.Promociones;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PromocionesRepository extends CrudRepository<Promociones, String> {

    public abstract ArrayList<Promociones> obtenerPorCategoria(String categoria);
    
}
