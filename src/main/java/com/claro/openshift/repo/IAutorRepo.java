package com.claro.openshift.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.claro.openshift.entity.Autor;

@Repository("autor_repo")
public interface IAutorRepo extends JpaRepository<Autor, String>{      
    @Query(value = "SELECT * FROM autor where id_autor=?", nativeQuery = true)
    Autor buscarAutorID(int id_autor);
}