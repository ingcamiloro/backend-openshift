package com.claro.openshift.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.claro.openshift.dao.IProductoDAO;
import com.claro.openshift.entity.Producto;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.model.ProductoDTO;
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
public class ProductoDAO  implements IProductoDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductoDAO.class);
 

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-5")
	private Date date = new Date();

	@Autowired
	private Environment env;

	@Autowired
	private JdbcTemplate jdbcTemplate;

    @Autowired
    private IProductoRepo repo;
	
	private JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}

    @Override
    public Producto consultar(Map<String,Object> mapa) {    
    
        return repo.buscarProducto(mapa.get("titulo_libro").toString());
    }


    public Page<Producto> get(int pagina, int tamano){    

        Pageable pageable =  PageRequest.of(pagina, tamano,Sort.by("id"));
        return repo.findAll(pageable); 

    }

    
    @Override
    public Producto crear(Producto producto) {    
      
        return  repo.save(producto);
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
            ResultSet res = callableStatement.getResultSet();
            res.next();            
            mapa.put("out_descripcion",res.getString("OUT_DESCRIPCION"));
            mapa.put("out_codigo",res.getString("OUT_CODIGO"));
            
            List<Producto>lista = new ArrayList<>();
            while (res.next()) {
                Producto pro=new Producto();       
                lista.add(pro);         
             
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
