/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.entidades.Producto;
import tienda.persistencia.FabricanteDAO;
import tienda.persistencia.ProductoDAO;

/**
 *
 * @author Mile
 */
public class ServicioProducto {
    
    private ProductoDAO dao;

    public ServicioProducto() {
        this.dao = new ProductoDAO();
    }
    
    public void crearProducto(String nombre, Double precio, Integer idFabricante) throws Exception{
        try {
            if (nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe indicar el nombre");
            }
            if (precio == null){
                throw new Exception("Debe indicar el precio");
            }
            if (idFabricante == null){
                throw new Exception("Debe indicar el id de fabricante");
            }            
            Producto producto = new Producto();
            producto.setNombre(nombre);
            producto.setPrecio(precio);
            producto.setCodigoFabricante(idFabricante);
                        
            dao.guardarProducto(producto);
        } catch (Exception e) {
            throw e;
        }
    }   
    
    
    public void modificarNombreProducto(int codigo, String nombreActual, String nombreNuevo) throws Exception{
        try {
            String codigoS = String.valueOf(codigo);
            if (codigoS == null || codigoS.trim().isEmpty()){
                throw new Exception("Debe indicar el codigo del fabricante");
            }
            if (nombreActual == null || nombreActual.trim().isEmpty()){
                throw new Exception("Debe indicar el nombre actual");
            }
            if (nombreNuevo == null || nombreNuevo.trim().isEmpty()){
                throw new Exception("Debe indicar el nombre nuevo");
            }
            
            Producto producto = buscarProductoPorCodigo(codigo);
            if (!producto.getNombre().equals(nombreActual)){
                throw new Exception("El nombre actual no es el registrado en el sistema para el nommbre indicado");
            }
            producto.setNombre(nombreNuevo);
            
            dao.modificarNombreProducto(producto);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    public Producto buscarProductoPorCodigo(int codigo) throws Exception{
        try {
            String codigoS = String.valueOf(codigo);
            //Validamos
            if (codigoS == null || codigoS.trim().isEmpty()) {
                throw new Exception("Debe indicar el codigo");
            }

            Producto producto = dao.buscarProductoPorCodigo(codigo);

            return producto;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarProducto(int codigo) throws Exception{
        try {
            String codigoS = String.valueOf(codigo);
            if (codigoS == null || codigoS.trim().isEmpty()){
                throw new Exception("Debe indicar el codigo");
            }
            
            dao.eliminarProducto(codigo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Collection<Producto> listarProducto() throws Exception {

        try {

            Collection<Producto> productos = dao.listarProductos();

            return productos;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirProducto() throws Exception {

        try {           
            Collection<Producto> productos = listarProducto();
                       
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void mostrarNombreProducto() throws Exception{
        try {
            Collection<Producto> productos = dao.listarProductos();
            if (productos.isEmpty()) {
                throw new Exception("No existen productos para imprimir");
            } else {
                for (Producto p : productos) {
                    System.out.println(p.getNombre());
                }
            }
        } catch (Exception e) {
        }
    }
    
    
    
}
