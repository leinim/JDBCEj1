/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.servicios.ServicioFabricante;
import tienda.servicios.ServicioProducto;

/**
 *
 * @author Mile
 */
public final class ProductoDAO extends DAO{   
    
    private final ServicioFabricante servicioFabricante;

    public ProductoDAO(){
        this.servicioFabricante = new ServicioFabricante();
    }    
    
     public void guardarProducto(Producto producto) throws Exception{
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto");
            }
            String sql = "INSERT INTO producto (nombre, precio, codigo_fabricante) "
                    + "VALUES ('" + producto.getNombre() + "', " + producto.getPrecio() + ", "+ producto.getCodigoFabricante() + ");"; 
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void modificarNombreProducto(Producto producto) throws Exception{
        try {
            if (producto == null) {
                throw new Exception("Debe indicar el producto que desea modificar");
            }
            String sql = "UPDATE producto "
                    + "SET nombre = '" + producto.getNombre() + "' WHERE codigo = '" + producto.getCodigo() + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void eliminarProducto(int codigo) throws Exception{
        try {
            String sql = "DELETE FROM producto WHERE id = " + codigo + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public Producto buscarProductoPorCodigo(int codigo) throws Exception{
        try{
            String sql = "SELECT * FROM producto WHERE codigo = " + codigo + ";";
            consultarBase(sql);
            Producto producto = null;
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
            }
            desconectarBase();
            return producto;
        }catch (Exception e){
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Producto> listarProductos() throws Exception{
        try {
            String sql = "SELECT * FROM Producto;";
            consultarBase(sql);
            Producto producto = null;
            Collection<Producto> productos = new ArrayList();
            while (resultado.next()) {
                producto = new Producto();
                producto.setCodigo(resultado.getInt(1));
                producto.setNombre(resultado.getString(2));
                producto.setPrecio(resultado.getDouble(3));
                producto.setCodigoFabricante(resultado.getInt(4));
                productos.add(producto);               
            }
            desconectarBase();
            return productos;            
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }    

    public Collection<Producto> consultarNombreProducto() throws Exception{
        try {
           String sql = "SELECT nombre FROM producto;";
           consultarBase(sql); 
           Producto producto = null;
           Collection<Producto> productos = listarProductos();
            while (resultado.next()) {
                producto = new Producto();                
                producto.setNombre(resultado.getString(1));
                productos.add(producto);
            }
            desconectarBase();
            return productos;
        } catch (Exception e) {
            desconectarBase();
            throw e;
        }
    }

    
    
    
    
}
