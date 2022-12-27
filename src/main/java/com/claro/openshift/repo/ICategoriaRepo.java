package com.claro.openshift.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.claro.openshift.entity.Categoria;

@Repository
public interface ICategoriaRepo extends JpaRepository<Categoria, String>{
  
}