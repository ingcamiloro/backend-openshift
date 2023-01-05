package com.claro.openshift.dao.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.claro.openshift.dao.IAutorDAO;
import com.claro.openshift.entity.Autor;
import com.claro.openshift.model.AutorDTO;
import com.claro.openshift.repo.IAutorRepo;
import org.springframework.core.env.Environment;

import org.springframework.stereotype.Service;

@Service("autor_dao")
public class AutorDAO implements IAutorDAO {

    @Autowired(required = true)
    private IAutorRepo repo;
    @Autowired
    private Environment env;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public Map<String, Object> get(int pagina, int tamano) {

        return null;
    }

    @Override
    public Map<String, Object> crear(Autor autor) {
        // return repo.save(autor);

        Connection connection = null;
        Map<String, Object> mapa = new HashMap<>();
        try {

            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callableStatement = connection.prepareCall(
                    env.getProperty("app.package.procedure.autor").replace("scheme", env.getProperty("app.scheme")));
            callableStatement.setString(1, "I");
            callableStatement.setNull(2, Types.NULL);
            callableStatement.setString(3, autor.getNombre());
            callableStatement.executeUpdate();
            ResultSet res = callableStatement.getResultSet();
            res.next();
            mapa.put("out_descripcion", res.getString("OUT_DESCRIPCION"));
            mapa.put("out_codigo", res.getString("OUT_CODIGO"));
            res.next();
            mapa.put("data", new AutorDTO(res.getInt("ID_AUTOR"), res.getString("NOMBRE_AUTOR")));

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

    @Override
    public Autor consultar(int id_autor) {

        return repo.buscarAutorID(id_autor);
    }

    @Override
    public List<AutorDTO> getList() {
        Connection connection = null;
        List<AutorDTO> lista = new ArrayList<>();
        try {

            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callableStatement = connection.prepareCall(
                    env.getProperty("app.package.procedure.autor").replace("scheme", env.getProperty("app.scheme")));
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
                    lista.add(new AutorDTO(res.getInt("ID_AUTOR"), res.getString("NOMBRE")));

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
