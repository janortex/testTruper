package com.truper.logic;

import com.truper.dao.DetalleVentaDao;
import com.truper.dao.VentasDao;
import com.truper.model.DetalleVenta;
import com.truper.model.RequestVenta;
import com.truper.model.Response;
import com.truper.model.Ventas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class DetalleVentaImpl implements DetalleVentaService{

    @Autowired
    private  DetalleVentaDao detalleVentaDao;

    @Autowired
    private VentasDao ventasDao;

    @Override
    public Response addVenta(RequestVenta venta) {
        DetalleVenta[] productos = venta.getProductos();
        Ventas ventax = new Ventas();
        ventax.setCliente(venta.getCliente());
        ventax.setRFC(venta.getRfc());

        float total = 0;
        List<DetalleVenta> detalleVentas = new ArrayList<>();
        for (int i = 0; i < productos.length; i++) {
            total+= productos[i].getPrecioventa();
            detalleVentas.add(productos[i]);
        }
        ventax.setDetventas(detalleVentas);
        ventax.setTotal(total);
        ventasDao.save(ventax);
        Response response = new Response();
        response.setEstatus(1);
        response.setMensaje("Productos Insertados");
        response.setFolio(UUID.randomUUID().toString());
        return response;
    }
}
