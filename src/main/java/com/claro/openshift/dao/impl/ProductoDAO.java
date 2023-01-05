package com.claro.openshift.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.claro.openshift.dao.IProductoDAO;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.model.ProductoDTO;
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
public class ProductoDAO  implements IProductoDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductoDAO.class);
 

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-5")
	private Date date = new Date();

	@Autowired
	private Environment env;

	@Autowired
	private JdbcTemplate jdbcTemplate;

  
	private JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}



    @Override
    public Map<String, Object> getFiltro(Map<String,Object> inParametros) {
        Connection connection = null;
        Map<String,Object> mapa =new HashMap<>() ;
        try {

            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callableStatement = connection.prepareCall(
                    env.getProperty("app.package.procedure.producto").replace("scheme", env.getProperty("app.scheme")));
            callableStatement.setString(1,"C");
            for (int i = 2; i <= 6; i++) {
                callableStatement.setNull(i, Types.NULL);
            }
            callableStatement.setInt(7,(int)inParametros.get("id_categoria"));
            for (int i = 8; i <= 9; i++) {
                callableStatement.setNull(i, Types.NULL);
            }
            callableStatement.setInt(10,(int)inParametros.get("autores"));
            for (int i = 11; i <= 12; i++) {
                callableStatement.setNull(i, Types.NULL);
            }
            callableStatement.registerOutParameter(13, Types.INTEGER);
            callableStatement.registerOutParameter(14, Types.VARCHAR);
            callableStatement.registerOutParameter(15, Types.INTEGER);
            callableStatement.executeUpdate();
            mapa.put("out_descripcion",callableStatement.getString("OUT_DESCRIPCION"));
            mapa.put("out_codigo",callableStatement.getString("OUT_CODIGO"));
            ResultSet res = callableStatement.getResultSet();                     
         
            
            List<ProductoDTO>lista = new ArrayList<>();
            while (res.next()) {
                ProductoDTO pro=new ProductoDTO();
                   
                lista.add(pro);         
             
            }
            mapa.put("out_cursor_info",lista);
           
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
    public Map<String, Object> getList() {
        Connection connection = null;
        Map<String,Object> mapa =new HashMap<>() ;
        try {

            connection = jdbcTemplate.getDataSource().getConnection();
            CallableStatement callableStatement = connection.prepareCall(
                    env.getProperty("app.package.procedure.producto").replace("scheme", env.getProperty("app.scheme")));
      
            for (int i = 1; i <= 15; i++) {
                callableStatement.setNull(i, Types.NULL);
            }
            callableStatement.executeUpdate();
            mapa.put("out_descripcion",callableStatement.getString("OUT_DESCRIPCION"));
            mapa.put("out_codigo",callableStatement.getString("OUT_CODIGO"));
            ResultSet res = callableStatement.getResultSet();             

            
            List<ProductoDTO>lista = new ArrayList<>();
            while (res.next()) {
                ProductoDTO pro=new ProductoDTO();
                   
                lista.add(pro);         
             
            }
            mapa.put("out_cursor_info",lista);
           
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
