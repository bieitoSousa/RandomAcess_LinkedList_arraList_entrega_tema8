/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practicaarraylist;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author bieito
 */
public class Fecha {
        Calendar today;
        String dia ;
        String mes ;
        String ano ;
        
        int idia;
        int imes;
        int iano;
                
        String separadorentrefecha= "-";
        String separadorentretextofecha=";";
        String separadorfinfecha=",,";
    
    Fecha (){
        Calendar today = Calendar.getInstance();
        this.dia =new SimpleDateFormat("dd").format(today.getTime());
        this.mes =new SimpleDateFormat("MM").format(today.getTime());
        this.ano =new SimpleDateFormat("yyyy").format(today.getTime());
        
      this.idia =Integer.parseInt(dia);
      this.imes=Integer.parseInt(mes);
      this.iano=Integer.parseInt(ano);  
}
    public Calendar getToday() {
        return today;
    }

    public String getDia() {
        return dia;
    }
    public int getintDia() {
        return idia;
    }
    public String getMes() {
        return mes;
    }
    public int getintMes() {
        return imes;
    }
    public String getAno() {
        return ano;
    }
    
      public int getintAno() {
        return iano;
    }
   static String fechahoy (String separador )  {
        Calendar today = Calendar.getInstance();
        String dia =new SimpleDateFormat("dd").format(today.getTime());
        String mes =new SimpleDateFormat("MM").format(today.getTime());
        String ano =new SimpleDateFormat("yyyy").format(today.getTime());
         return dia+separador+mes+separador+ano;
   } 
     static String horahoy (String separador )  {
        Calendar today = Calendar.getInstance();
        String hora =new SimpleDateFormat("hh").format(today.getTime());
        String minuto =new SimpleDateFormat("mm").format(today.getTime());
        String segundo =new SimpleDateFormat("ss").format(today.getTime());
         return hora+separador+minuto+separador+segundo;
   }  
   
   
   static String fechahoy (String separafechastring ,String finfecha , String texto){
         Calendar today = Calendar.getInstance();
        String dia =new SimpleDateFormat("dd").format(today.getTime());
        String mes =new SimpleDateFormat("MM").format(today.getTime());
        String ano =new SimpleDateFormat("yyyy").format(today.getTime());
        return texto+separafechastring+Fecha.fechahoy("-")+finfecha;
     
   }
    String fechahoy (){
     return this.dia+this.separadorentrefecha+this.mes+this.separadorentrefecha+this.ano;
        }
    String fechahoyaddtexto(String texto){       
         return texto+separadorentretextofecha+fechahoy()+separadorfinfecha;
    }    
    }

