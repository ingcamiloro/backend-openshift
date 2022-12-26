package com.claro.openshift.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.claro.openshift.dao.ICategoriaDAO;
import com.claro.openshift.entity.Categoria;
import com.claro.openshift.model.CategoriaDTO;

@Repository
@Transactional
public class CategoriaDAO implements ICategoriaDAO {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void consultar(CategoriaDTO categoria) {

    }

    public Categoria buscarId(int id) {
        String sql = "SELECT * FROM categoria WHERE id_categoria = ?";

        Categoria categoria = null;
        Connection connection = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                categoria = new Categoria();
                categoria.setId(res.getInt("id_categoria"));
                categoria.setNombre(res.getString("nombre"));
            }
            res.close();
            ps.close();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return categoria;

    }

    @Override
    public CategoriaDTO crear(CategoriaDTO categoria) {
        String crearApp = "INSERT INTO categoria (nombre) VALUES (?)";        
        Connection connection = null;
        PreparedStatement ps;
        Categoria obj = null ;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            ps = connection.prepareStatement(
                    crearApp,
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setString(1, categoria.getNombre());
            ps.executeUpdate();
            ResultSet res = ps.getGeneratedKeys();        
            if (res.next()) {
                int id = res.getInt(1);         
                obj = buscarId(id);         
            }
            res.close();
            ps.close();
            if(obj != null){
                return new CategoriaDTO(obj.getId(), obj.getNombre());
            }            
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

        return null;
    }

}
