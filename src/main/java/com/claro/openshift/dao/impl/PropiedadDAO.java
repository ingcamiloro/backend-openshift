package com.claro.openshift.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.claro.openshift.dao.IProductoDAO;
import com.claro.openshift.dao.IPropiedadDAO;
import com.claro.openshift.entity.Producto;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.model.ProductoDTO;
import com.claro.openshift.model.PropiedadesDTO;
import com.claro.openshift.repo.IProductoRepo;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.core.env.Environment;
import javax.transaction.Transactional;
import org.springframework.data.domain.Sort;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

@Service
public class PropiedadDAO implements IPropiedadDAO {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-5")
    private Date date = new Date();

    @Autowired
    private Environment env;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<PropiedadesDTO> consultarPropiedades(PropiedadesDTO propiedad) {
        Connection connection = null;
        List<PropiedadesDTO> lista = new ArrayList<>();
        try {

            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callableStatement = connection.prepareCall(
                    env.getProperty("app.package.procedure.propiedades").replace("scheme", env.getProperty("app.scheme")));
            callableStatement.setString(1, propiedad.getCodapp());
            callableStatement.setString(2, propiedad.getNombre());
            callableStatement.setString(3, propiedad.getValor());
            callableStatement.setString(4, propiedad.getAccion());
            callableStatement.registerOutParameter(5, Types.INTEGER);
            callableStatement.registerOutParameter(6, Types.VARCHAR);
            callableStatement.executeUpdate();    
        
            int codigo = callableStatement.getInt(5);
            if(codigo == 0 ){
                ResultSet res = callableStatement.getResultSet();
                while (res.next()) {
                    propiedad = new PropiedadesDTO(propiedad.getAccion(), propiedad.getCanal(), res.getString("COD_APP"), res.getString("NOMBRE"), res.getString("VALOR"));                    
                    lista.add(propiedad);
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
