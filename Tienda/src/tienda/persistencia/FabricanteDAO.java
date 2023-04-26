/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda.persistencia;

import java.util.ArrayList;
import java.util.Collection;
import tienda.entidades.Fabricante;
import tienda.servicios.ServicioFabricante;

/**
 *
 * @author Mile
 */
public final class FabricanteDAO extends DAO{    
   
    public void guardarFabricante(Fabricante fabricante) throws Exception{
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante");
            }
            String sql = "INSERT INTO fabricante (nombre) "
                    + "VALUES ('" + fabricante.getNombre() + "');"; 
            System.out.println(sql);
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void modificarNombreFabricante(Fabricante fabricante) throws Exception{
        try {
            if (fabricante == null) {
                throw new Exception("Debe indicar el fabricante que desea modificar");
            }
            String sql = "UPDATE fabricante "
                    + "SET nombre = '" + fabricante.getNombre() + "' WHERE codigo = '" + fabricante.getCodigo() + "';";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public void eliminarFabricante(int codigo) throws Exception{
        try {
            String sql = "DELETE FROM fabricante WHERE id = " + codigo + ";";
            insertarModificarEliminar(sql);
        } catch (Exception e) {
            throw e;
        } finally {
            desconectarBase();
        }
    }
    
    public Fabricante buscarFabricantePorCodigo(int codigo) throws Exception{
        try{
            String sql = "SELECT * FROM fabricante WHERE codigo = " + codigo + ";";
            consultarBase(sql);
            Fabricante fabricante = null;
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));            
            }
            desconectarBase();
            return fabricante;
        }catch (Exception e){
            desconectarBase();
            throw e;
        }
    }
    
    public Collection<Fabricante> listarFabricantes() throws Exception{
        try {
            String sql = "SELECT * FROM fabricante;";
            consultarBase(sql);
            Fabricante fabricante = null;
            Collection<Fabricante> fabricantes = new ArrayList();
            while (resultado.next()) {
                fabricante = new Fabricante();
                fabricante.setCodigo(resultado.getInt(1));
                fabricante.setNombre(resultado.getString(2));
                fabricantes.add(fabricante);               
            }
            desconectarBase();
            return fabricantes;            
        } catch (Exception e) {
            e.printStackTrace();
            desconectarBase();
            throw e;
        }
    }
        
    
}
