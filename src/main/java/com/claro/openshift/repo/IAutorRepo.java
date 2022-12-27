package com.claro.openshift.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.claro.openshift.entity.Autor;

@Repository
public interface IAutorRepo extends JpaRepository<Autor, String>{
  
}