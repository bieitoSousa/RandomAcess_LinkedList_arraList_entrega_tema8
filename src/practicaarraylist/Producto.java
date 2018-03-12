
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaarraylist;

/**
 *
 * @author bieito
 */
public class Producto {
    public String  nombre ;
    public int  precio ;

        Producto (String  nombre,int  precio){
        this.nombre=nombre
                ;
        this.precio=precio;
        }
        @Override
        public String toString(){
        return  "Codigo : " + nombre + "  precio " + precio ;
        }

} 


