/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaarraylist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static practicaarraylist.RandomAcces.escribirFichero;

/**
 *
 * @author bieito
 */
public class PracticaarrayList {

            Scanner sc = new Scanner(System.in);
            ArrayList <Venta> arrLstVen= new ArrayList <Venta> ();
            LinkedList <Historico> linkHistorico= new LinkedList <Historico> ();
            LinkedList <Historico> guardadoEnFile= new LinkedList <Historico> ();
             HashMap <String , Producto> ColeccionCodigos = new  HashMap() ;
            Fecha f = new Fecha();
            int dia = f.getintDia();
            int mes =f.getintMes();
            long ano =f.getintAno();
            
          public void addventaarryList(Venta v) throws Exception {
          
              int c =arrLstVen.size();
              arrLstVen.add( arrLstVen.size(), v);
              int d =arrLstVen.size();
              if (c<d)System.out.println("se ha añadido la venta correctamente");
              else throw new Exception("no se ha añadido la venta");
              
          }  
            
           public  void recorrerymostrararryList(){
                int cd1=0;
                    System.out.println("con Array list ");
                System.out.println("------------------------");
                for ( Venta v  : this.arrLstVen){
                    System.out.println(v.toString()); 
                cd1=    v.precio+ cd1;
                }
                System.out.println("el precio es ----"+cd1);
                System.out.println("------------------------");
               
                
            }
            
                     
            public void recorrerymostrarLinkListHistorico(){
                
              
                
                    System.out.println("Recorriendo Historico ");
                System.out.println("------------------------");
                for (Historico h : this.linkHistorico){
                    System.out.println(h.toString());
                }
               
               
               System.out.println("------------------------");
               
            }   
            void crearColeccionCodigos() {
                System.out.println("creando ColeccionCodigos"  );   
                ColeccionCodigos.put("a1", new Producto ("carne",2));
                ColeccionCodigos.put("a2", new Producto ("pescado",5));
                ColeccionCodigos.put("a3", new Producto ("verdura",3));
                ColeccionCodigos.put("a4", new Producto ("hortalizas",3));
                ColeccionCodigos.put("a5", new Producto ("lacteos",2));
                ColeccionCodigos.put("a6", new Producto ("embutidos",1));
                ColeccionCodigos.put("a7", new Producto ("legumbres",3));
                }
            
         void mostrarColeccionCodigos(){
                            //ColeccionCodigos.
                    Iterator it = ColeccionCodigos.entrySet().iterator();
                   while (it.hasNext()) {
                   Map.Entry e = (Map.Entry)it.next();
                   System.out.println(e.getKey() + " " + e.getValue());
                                }
         }   
         
 Producto dameProducto(String a){
               
       Producto p = null;    
        if (ColeccionCodigos.containsKey(a)){
         p = ColeccionCodigos.get(a);
    }else System.out.println("Producto no encontrado");
        return p;
    }
 
 
 
    void hacerticket() throws Exception{
       String cdtxt = "" ;
            Venta v = null;
		do { 
			System.out.println("introuce el codigo [-1 para salir ]");// mensage por pantalla
				cdtxt = sc.nextLine(); // cojo la entrada por taclado
                                Producto p =dameProducto(cdtxt);
                                    if (p != null )pasarTicketaVenta(cdtxt);

                    }while(!(cdtxt.equals("-1")) );
                
           recorrerymostrararryList();
           System.out.println("pulsa enter ");
           sc.nextLine(); 
    
    
    }
            
                 

    void pasarTicketaVenta( String str) throws Exception{       
        Producto a= dameProducto(str);     
       if (a != null) ;
       {Venta v = new Venta(str,a.precio,dia,mes,ano);
       addventaarryList(v);
       }
    }
    void updateHistorico(String codigo) throws IOException{
        Historico hist ;
     boolean update= true;   
    if(linkHistorico.size()!=0){

    for(Historico h : linkHistorico){
        System.out.println("entrando en el bucle");    
        if (h.codigo.equals(codigo)){
              h.historico++;
            System.out.println("sumando a historico "+codigo+"---"+h.historico);
            
             RandomAcces.modificarFichero(h.codigo,h.historico);
             System.out.println("fichero modificado");
            update = false;
        }
    }
    if (update==true){
        System.out.println("creando Historico nuevo "+codigo);
             hist=new Historico(codigo,1);
            linkHistorico.push(new Historico(codigo,1));
             RandomAcces.escribirFichero(hist.codigo,hist.historico);
    }
    }else{
     System.out.println("se empieza Historico");
        hist=new Historico(codigo,1);
        linkHistorico.push(new Historico(codigo,1));
          RandomAcces.escribirFichero(hist.codigo,hist.historico);
        
        
    }
            }   
    void hacerCaja() throws IOException{
    System.out.println("haciendo caja");
                System.out.println("------------------------");
                int id;
                
                for ( Venta v  : this.arrLstVen){
                    System.out.println("pasando "+v.toString());

        updateHistorico(v.codigo);
                    System.out.println("---fin update historico----");
                }
    } 

    
    int menu() {
        
        System.out.println("------------------------");
        System.out.println("Seleccione :");
        System.out.println("1.- Inicio de venta ");
        System.out.println("2.- Caja");
        System.out.println("3.- Salir");
        System.out.println("numero de codigos en historico -->"+linkHistorico.size());
        System.out.println("------------------------");
        int out =Integer.parseInt(sc.nextLine());
     return out;
    }
            
    /**
     * @param args the command line arguments
     */
   
    
    
    public static void main(String[] args) throws Exception {
     PracticaarrayList pl = new PracticaarrayList();   
      int op = 0;
      pl.crearColeccionCodigos();
      pl.iniciarHistorico();
do {
     
    pl.mostrarColeccionCodigos();
   
    pl.recorrerymostrarLinkListHistorico();
    
    
    
    op =pl.menu(); 
	switch (op){

            case 1 : // mostrar ticket
                
                Producto p =pl.dameProducto("a1");
                System.out.println("el producto p es "+p.toString());        
                
                 pl.hacerticket();
                 break;
				
            case 2 : 
                
                pl.hacerCaja();
                pl.recorrerymostrarLinkListHistorico();
                pl.leerFicheroHistoricos();
                pl.recorrerymostrarLinkListHistoricoFile();

                
                break;
            case 3 : // salir
		break;

}
    }while(op!=3);
    
}

    public void escribirFicheroHistoricos() {
        for(Historico h:this.linkHistorico){
        RandomAcces.escribirFichero(h.codigo,h.historico);
        }
    }
    public void leerFicheroHistoricos() {
                try {
                   this.guardadoEnFile= RandomAcces.mostrarFichero();
                } catch (IOException ex) {
                    System.out.println("no se a podido leer el fichero ");
                }
    
         }

    private void recorrerymostrarLinkListHistoricoFile() {
                    System.out.println("Recorriendo Historico ");
                System.out.println("------------------------");
                for (Historico h : this.linkHistorico){
                    System.out.println(h.toString());
    }
}
    private void iniciarHistorico(){
                if(RandomAcces.fhistorico.length()>4){
                leerFicheroHistoricos();
                this.linkHistorico=this.guardadoEnFile;
                
                }
 
 }
}

