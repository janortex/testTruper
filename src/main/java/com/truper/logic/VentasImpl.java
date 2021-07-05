package com.truper.logic;

import com.truper.dao.VentasDao;
import com.truper.model.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VentasImpl implements VentasService{

    @Autowired
    private VentasDao ventasDao;

    @Override
    public List<Ventas> getVentaS() {
        List<Ventas> ventas = ventasDao.findAll();
        System.out.println(ventas.size());
        return ventas;


    }
}
