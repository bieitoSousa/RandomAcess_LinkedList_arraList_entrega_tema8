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
public class Historico {
   
        public String  codigo ;
        public int  historico ;

            Historico (String  codigo,int  historico){
            this.codigo=codigo;
            this.historico=historico;
            }

            @Override
            public String toString(){
            return "Codigo : " + codigo + "  cantidad " + historico ;
            }


} 




