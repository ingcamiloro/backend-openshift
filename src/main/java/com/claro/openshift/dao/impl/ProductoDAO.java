package com.claro.openshift.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import com.claro.openshift.dao.IProductoDAO;
import com.claro.openshift.model.CategoriaDTO;
import com.claro.openshift.model.ProductoDTO;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Repository
@Transactional
public class ProductoDAO  implements IProductoDAO {

    private static final Logger logger = LoggerFactory.getLogger(ProductoDAO.class);
    

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "GMT-5")
	private Date date = new Date();

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	private JdbcTemplate getJdbcTemplate(){
		return jdbcTemplate;
	}

    @Override
    public List<ProductoDTO> consultar(ProductoDTO libro) {

        



        List<ProductoDTO> lista = new ArrayList<>();
    
        return lista;
    }

    public int count (){

        
        String sql = "SELECT count(*) as total FROM producto ";
        int total= 0;
        Connection connection = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
     
            ResultSet res = ps.executeQuery();
        
            if (res.next()) {
                total = res.getInt("total");            
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

        return total;
    }


    public Map<String,Object> get(int pagina, int tamano){    

        String sql = "SELECT * FROM producto order by id_producto asc limit "+(pagina -1 * tamano)+","+ tamano;

        sql = "select * from producto inner join categoria on categoria.id_categoria=producto.fk_idCategoria order by id_producto;";

        List<ProductoDTO> lista = null;
        Connection connection = null;
        Map<String, Object>mapa = new HashMap<String, Object>();
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
     
            ResultSet res = ps.executeQuery();
            lista = new ArrayList<>(); 
            while (res.next()) {
                ProductoDTO producto = new ProductoDTO();
                producto.setId(res.getInt("id_producto"));    
                producto.setTitulo(res.getString("titulo"));   
                producto.setFechaInactivacion(res.getDate("fechaInactivacion"));   
                producto.setTipoProducto(res.getString("tipoProducto"));   
                producto.setCantidadEjemplares(res.getInt("cantidadEjemplares"));   
                producto.setPeriodoMaximoPrestamo(res.getInt("periodoMaximoPrestamo")); 
                producto.setFechaIngreso(res.getDate("fechaIngreso"));
                CategoriaDTO categoria = new CategoriaDTO(res.getInt("id_categoria"),res.getString("nombre"));               
                producto.setCategoria(categoria);                
                lista.add(producto);       
            }
            res.close();
            ps.close();
            mapa.put("data", lista);
            mapa.put("total", count());
            mapa.put("pagina", pagina);



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

        return mapa;

    }

    
    @Override
    public ProductoDTO crear(ProductoDTO producto) {
        StringBuffer crearApp = new StringBuffer(); 
        crearApp.append("INSERT INTO producto");
        crearApp.append("(fk_idCategoria,");
        crearApp.append("tipoProducto,");
        crearApp.append("cantidadEjemplares,");
        crearApp.append("periodoMaximoPrestamo,");
        crearApp.append("titulo,");
        crearApp.append("fechaInactivacion,");
        crearApp.append("fechaIngreso) ");
        crearApp.append("VALUES (?,?,?,?,?,?,?)");        
        Connection connection = null;
        PreparedStatement ps;
        ProductoDTO productoOut = null ;
        String sql = crearApp.toString();
        System.out.println("sql "+sql);

        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            ps = connection.prepareStatement(
                  crearApp.toString(),
                    PreparedStatement.RETURN_GENERATED_KEYS);

            ps.setInt(1, producto.getCategoria().getId());
            ps.setString(2, producto.getTipoProducto());
            ps.setInt(3, producto.getCantidadEjemplares());
            ps.setInt(4, producto.getPeriodoMaximoPrestamo());
            ps.setString(5, producto.getTitulo());
            ps.setDate(6, new java.sql.Date(producto.getFechaInactivacion().getTime()));
            ps.setDate(7, new java.sql.Date( producto.getFechaIngreso().getTime()));
            ps.executeUpdate();
            ResultSet res = ps.getGeneratedKeys();        
            if (res.next()) {
                int id = res.getInt(1);         
                productoOut = buscarId(id);         
            }
            res.close();
            ps.close();
            if(productoOut != null){
                return productoOut;
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


    public ProductoDTO buscarId(int id) {
        String sql = "select * from producto inner join categoria on categoria.id_categoria=producto.fk_idCategoria where producto.id_producto = ?";

        ProductoDTO producto = null;
        Connection connection = null;
        try {
            connection = jdbcTemplate.getDataSource().getConnection();
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.next()) {
                producto = new ProductoDTO();
                producto.setId(res.getInt("id_producto"));    
                producto.setTitulo(res.getString("titulo"));   
                producto.setFechaInactivacion(res.getDate("fechaInactivacion"));   
                producto.setTipoProducto(res.getString("tipoProducto"));   
                producto.setCantidadEjemplares(res.getInt("cantidadEjemplares"));   
                producto.setPeriodoMaximoPrestamo(res.getInt("periodoMaximoPrestamo")); 
                producto.setFechaIngreso(res.getDate("fechaIngreso"));
                CategoriaDTO categoria = new CategoriaDTO(res.getInt("id_categoria"),res.getString("nombre"));               
                producto.setCategoria(categoria);   
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

        return producto;

    }

}
