package com.solar.code.service;

import com.solar.code.model.Categoria;
import com.solar.code.model.Producto;
import com.solar.code.repository.CategoriaRepository;
import com.solar.code.repository.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {
  @Autowired
  private ProductoRepository productoRepository;


  // ACCIONES

  public List<Producto> consultarProductos(){
    return productoRepository.findAll();
  }

  public Producto guardarProducto(Producto producto) {
    return productoRepository.save(producto);
  }

  public Producto encontrarProductoPorID(Long producto_id) {
    Optional<Producto> productoOptional = productoRepository.findById(producto_id);
    return productoOptional.orElse(null);
  }

  public Producto actualizarProducto(Producto producto){
    if(productoRepository.existsById(producto.getId())){
      return productoRepository.save(producto);
    } else {
      return null;
    }
  }

  public boolean eliminarProducto(Long producto_id){
    if(productoRepository.existsById(producto_id)){
      productoRepository.deleteById(producto_id);
      return true;
    } else{
      return false;
    }
  }



}
