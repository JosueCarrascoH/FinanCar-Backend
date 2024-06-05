package com.solar.code.service;

import com.solar.code.model.Categoria;
import com.solar.code.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
  @Autowired
  private CategoriaRepository categoriaRepository;

  // ACCIONES

  public List<Categoria> consultarCategorias(){
    return categoriaRepository.findAll();
  }

  public Categoria guardarCategoria(Categoria categoria){
    return categoriaRepository.save(categoria);
  }

  public Categoria encontrarCategoriaPorId(Long categoriaId){
    Optional<Categoria> categoriaOptional = categoriaRepository.findById(categoriaId);
    return categoriaOptional.orElse(null);
  }


  public Categoria actualizarCategoria(Categoria categoria){
    if(categoriaRepository.existsById(categoria.getId())){
      return categoriaRepository.save(categoria);
    } else {
      return null;
    }
  }

  public boolean eliminarCategoria(Long categoriaId){
    if(categoriaRepository.existsById(categoriaId)){
      categoriaRepository.deleteById(categoriaId);
      return true;
    } else{
      return false;
    }
  }
}
