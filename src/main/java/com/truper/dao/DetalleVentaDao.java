package com.truper.dao;

import com.truper.model.DetalleVenta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface DetalleVentaDao extends CrudRepository<DetalleVenta,Integer> {


}
