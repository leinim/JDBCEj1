/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.servicios;

import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.persistencia.FabricanteDAO;

/**
 *
 * @author Mile
 */
public class ServicioFabricante {  
    
    private final FabricanteDAO dao;

    public ServicioFabricante() {
        this.dao = new FabricanteDAO();
    }   
    
    public void crearFabricante(String nombre) throws Exception{
        try {
            if (nombre == null || nombre.trim().isEmpty()){
                throw new Exception("Debe indicar el nombre");
            }
            
            Fabricante fabricante = new Fabricante();
            fabricante.setNombre(nombre);
            
            dao.guardarFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }
    }
    
    //Modificar por id, eliminar, buscar por id, listar, imprimir 
    public void modificarNombreFabricante(int codigo, String nombreActual, String nombreNuevo) throws Exception{
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
            
            Fabricante fabricante = buscarFabricantePorCodigo(codigo);
            if (!fabricante.getNombre().equals(nombreActual)){
                throw new Exception("El nombre actual no es el registrado en el sistema para el nommbre indicado");
            }
            fabricante.setNombre(nombreNuevo);
            
            dao.modificarNombreFabricante(fabricante);
        } catch (Exception e) {
            throw e;
        }        
    }
    
    public Fabricante buscarFabricantePorCodigo(int codigo) throws Exception{
        try {
            String codigoS = String.valueOf(codigo);
            //Validamos
            if (codigoS == null || codigoS.trim().isEmpty()) {
                throw new Exception("Debe indicar el correo electrónico");
            }

            Fabricante fabricante = dao.buscarFabricantePorCodigo(codigo);

            return fabricante;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void eliminarFabricante(int codigo) throws Exception{
        try {
            String codigoS = String.valueOf(codigo);
            if (codigoS == null || codigoS.trim().isEmpty()){
                throw new Exception("Debe indicar el codigo");
            }
            
            dao.eliminarFabricante(codigo);
        } catch (Exception e) {
            throw e;
        }
    }
    
    public Collection<Fabricante> listarFabricante() throws Exception {

        try {

            Collection<Fabricante> fabricantes = dao.listarFabricantes();

            return fabricantes;
        } catch (Exception e) {
            throw e;
        }
    }
    
    public void imprimirFabricantes() throws Exception {

        try {           
            Collection<Fabricante> fabricantes = listarFabricante();
                       
            if (fabricantes.isEmpty()) {
                throw new Exception("No existen fabricantes para imprimir");
            } else {
                for (Fabricante f : fabricantes) {
                    System.out.println(f);
                }
            }
        } catch (Exception e) {
            throw e;
        }
    }
}
