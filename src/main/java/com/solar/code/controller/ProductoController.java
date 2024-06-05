package com.solar.code.controller;

import com.solar.code.model.Producto;
import com.solar.code.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/data")
public class ProductoController {
  @Autowired
  private ProductoService productoService;

  @PostMapping("/guardarData")
  public Producto guardarProducto(@RequestBody Producto producto) {
    return productoService.guardarProducto(producto);
  }

  @GetMapping("/obtenerData")
  public List<Producto> obtenerProducto() {
    return productoService.consultarProductos();
  }

  @GetMapping("/encontrarDataPorId/{data_id}")
  public Producto encontrarProductoPorId(@PathVariable Long data_id) {
    return productoService.encontrarProductoPorID(data_id);
  }

  @DeleteMapping("/eliminarProducto/{producto_id}")
  public boolean eliminarProducto(@PathVariable Long producto_id) {
    return productoService.eliminarProducto(producto_id);
  }
}
