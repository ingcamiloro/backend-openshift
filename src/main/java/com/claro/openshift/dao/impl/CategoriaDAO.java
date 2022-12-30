package com.claro.openshift.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.jdbc.core.JdbcTemplate;

import com.claro.openshift.dao.ICategoriaDAO;
import com.claro.openshift.entity.Categoria;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.repo.ICategoriaRepo;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;
@Service
public class CategoriaDAO implements ICategoriaDAO {
    @Autowired
    private ICategoriaRepo repo;
  
    @Override
    public Categoria consultar(int id_categoria) {
        return repo.buscarCategoriaID(id_categoria);
    } 
    @Autowired
    private Environment env;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public CategoriaDTO crear(Categoria categoria) {

        Categoria res = repo.save(categoria);
        return new CategoriaDTO(res.getId(),res.getNombre());
      
    }
    @Override
     public Page<Categoria> get(int pagina, int tamano){  

        Pageable pageable =  PageRequest.of(pagina, tamano,Sort.by("id"));
        return repo.findAll(pageable); 

    }

    @Override
    public Map<String, Object> getList() {
     
          

        Connection connection = null;
        Map<String,Object> mapa =new HashMap<>() ;

        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callableStatement = connection.prepareCall(
                    env.getProperty("app.package.procedure.categoria").replace("scheme", env.getProperty("app.scheme")));
            callableStatement.setString(1, "C");
            callableStatement.setNull(2, Types.NULL);
            callableStatement.setNull(3, Types.NULL);
            callableStatement.executeUpdate();
            ResultSet res = callableStatement.getResultSet();
            res.next();            
            mapa.put("out_descripcion",res.getString("OUT_DESCRIPCION"));
            mapa.put("out_codigo",res.getString("OUT_CODIGO"));
                
            List<CategoriaDTO> lista = new ArrayList<>();
            while (res.next()) {
                lista.add(new CategoriaDTO(res.getInt("ID_CATEGORIA"),res.getString("NOMBRE_CATEGORIA")));
                
            }   
            mapa.put("data",lista);        
            
            res.close();
            callableStatement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
            
                    e.printStackTrace();
                }
            }
        }
        return mapa;
    }

}
