/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tienda;

import java.util.InputMismatchException;
import java.util.Scanner;
import tienda.persistencia.DAO;
import tienda.persistencia.ProductoDAO;
import tienda.servicios.ServicioFabricante;
import tienda.servicios.ServicioProducto;

/**
 *
 * @author Mile
 */
public class Tienda {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws Exception {
        ServicioFabricante sf = new ServicioFabricante();
        ServicioProducto sp = new ServicioProducto();
        
        try {
            sf.crearFabricante("Milena");
            sf.crearFabricante("Euge");
            sp.crearProducto("Portatil", 110.0, 2);
            sp.crearProducto("Camara", 127.0, 1);
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Error del sistema por \n" + e.getMessage());
        }
        Scanner leer = new Scanner(System.in);
        int opcion = 0;
        
        /*  a) Lista el nombre de todos los productos que hay en la tabla producto.
            b) Lista los nombres y los precios de todos los productos de la tabla producto.
            c) Listar aquellos productos que su precio esté entre 120 y 202.
            d) Buscar y listar todos los Portátiles de la tabla producto.
            e) Listar el nombre y el precio del producto más barato.
            f) Ingresar un producto a la base de datos.
            g) Ingresar un fabricante a la base de datos
            h) Editar un producto con datos a elección. */
        
        try {
            System.out.println("--MENÚ--");
            System.out.println("Elija su consulta:");
            System.out.println("1 - Nombre de todos los productos que hay en la tabla producto.");
            System.out.println("2 - Nombres y precios de todos los productos de la tabla producto. ");
            System.out.println("3 - Productos que su precio esté entre 120 y 202.");
            System.out.println("4 - Portátiles de la tabla producto.");
            System.out.println("5 - Nombre y precio del producto más barato.");
            System.out.println("6 - Ingresar un producto a la base de datos.");
            System.out.println("7 - Ingresar un fabricante a la base de datos.");
            System.out.println("8 - Editar un producto con datos a elección.");

            opcion = leer.nextInt();

            switch (opcion){
                case 1:                    
                    sp.mostrarNombreProducto();
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:    
                    
                    break;
                case 5:
                    
                    break;
                case 6:
               
                    break;
                case 7:
                    try {
                        System.out.println("Ingrese el nombre del fabricante");
                        String nombre = leer.next();
                        if (nombre == null || nombre.trim().isEmpty()){
                            throw new Exception("Debe indicar el nombre");
                        }
                        sf.crearFabricante(nombre);                        
                    } catch (Exception e) {
                        e.printStackTrace();
                        System.out.println("Error del sistema por \n" + e.getMessage());
                    }
                    break;
                case 8:
                    
                    break;
                default:
                    System.out.println("Opcion incorrecta.Intente nuevamente.");
            }
        }catch(NumberFormatException | InputMismatchException e){
            throw e;
        }
    }
    
}
