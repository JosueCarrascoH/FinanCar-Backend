package com.solar.code.controller;

import com.solar.code.model.Categoria;
import com.solar.code.model.Producto;
import com.solar.code.service.CategoriaService;
import com.solar.code.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path= "api/v1/user")
public class CategoriaController {
  @Autowired
  CategoriaService categoriaService;
  @PostMapping("/guardarUser")
  public Categoria guardarCategoria(@RequestBody Categoria categoria) {
    return categoriaService.guardarCategoria(categoria);
  }
  @GetMapping("/obtenerUser")
  public List<Categoria> obtenerCategorias() {
    return categoriaService.consultarCategorias();
  }
  @GetMapping("/encontrarUserPorId/{user_id}")
  public Categoria encontrarCategoriaPoriD(@PathVariable Long user_id){
    return categoriaService.encontrarCategoriaPorId(user_id);
  }
  @PutMapping("/actualizarUsera")
  public Categoria actualizarCategoria(@RequestBody Categoria categoria){
    return categoriaService.actualizarCategoria(categoria);
  }

  @DeleteMapping("/eliminarUser/{user_id}")
  public boolean eliminarCategoria(@PathVariable Long user_id){
    return categoriaService.eliminarCategoria(user_id);
  }
}
