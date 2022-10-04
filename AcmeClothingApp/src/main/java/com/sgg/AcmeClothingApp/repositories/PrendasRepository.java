package com.sgg.AcmeClothingApp.repositories;

import com.sgg.AcmeClothingApp.models.Prendas;
import java.util.ArrayList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PrendasRepository extends CrudRepository<Prendas, String> {

    public abstract ArrayList<Prendas> obtenerPorCategoria(String categoria);
}
