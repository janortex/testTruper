package com.truper.dao;

import com.truper.model.Ventas;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VentasDao extends JpaRepository<Ventas,Integer> {

}
