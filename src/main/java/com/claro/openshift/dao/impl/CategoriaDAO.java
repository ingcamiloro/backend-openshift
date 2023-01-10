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
import com.claro.openshift.model.CategoriaDTO;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;

@Service
public class CategoriaDAO implements ICategoriaDAO {

  
    @Autowired
    private Environment env;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public CategoriaDTO crear(CategoriaDTO categoria) {


        Connection connection = null;
        CategoriaDTO categoriaRes = null;
        try {

            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callableStatement = connection.prepareCall(
                env.getProperty("app.package.procedure.categoria").replace("scheme",
                        env.getProperty("app.scheme")));
            callableStatement.setString(1, "I");
            callableStatement.setNull(2, Types.NULL);
            callableStatement.setString(3,categoria.getNombre_categoria());
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.VARCHAR);
            callableStatement.executeUpdate();
            ResultSet res = callableStatement.getResultSet();    
            int codigo = callableStatement.getInt(5);
            if(codigo == 0 ){
                 res.next();
                categoriaRes= new CategoriaDTO(res.getInt("ID_CATEGORIA"), res.getString(env.getProperty("categoria.nombre").toString()));
                res.close();
            }
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
        return categoriaRes;

    }

    @Override
    public List<CategoriaDTO> getList() {

        Connection connection = null;
        List<CategoriaDTO> lista = new ArrayList<>();
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callableStatement = connection.prepareCall(
                    env.getProperty("app.package.procedure.categoria").replace("scheme",
                            env.getProperty("app.scheme")));
            callableStatement.setString(1, "C");
            callableStatement.setNull(2, Types.NULL);
            callableStatement.setNull(3, Types.NULL);
            callableStatement.registerOutParameter(4, Types.INTEGER);
            callableStatement.registerOutParameter(5, Types.VARCHAR);
            callableStatement.executeUpdate();

            int codigo = callableStatement.getInt(4);
            if (codigo == 0) {
                ResultSet res = callableStatement.getResultSet();
                while (res.next()) {
                    lista.add(new CategoriaDTO(res.getInt("ID_CATEGORIA"), res.getString("NOMBRE")));

                }
                res.close();
            }

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
        return lista;
    }

}
