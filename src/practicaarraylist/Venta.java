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
class Venta {
    
   String codigo ;
   int precio;
   int dia;
   int mes ;
   long ano ;
   
   Venta(
   String codigo ,
   int precio,
   int dia,
   int mes ,
   long ano 
   ){
        this.codigo= codigo ;
        this.precio=precio;
        this.dia=dia;
        this.mes=mes ;
        this.ano=ano ;   

}
    
    
   @Override
    public String toString (){
    
    return "El codigo : "+codigo +"--> Precio "+precio+"  "+dia+"-"+mes+"-"+ano;
    }
    
    
    
}
