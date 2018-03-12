package practicaarraylist;

import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.LinkedList;
import java.util.Scanner;

public class RandomAcces {

    static Scanner sc = new Scanner(System.in);
    static RandomAccessFile fichero = null;
        final static String urlpath = "C:\\Users\\bieito\\Documents\\temp\\Java";
	final static String urlhistorico = urlpath+"historicoArray.dat";
	final static File fhistorico = new File (urlhistorico);
        
        static int byteint= Integer.BYTES;
        static String texto= "a1";
        static  int bytetexto= texto.getBytes().length;

    static void modificarFichero(String texto, int numero) throws FileNotFoundException, IOException {
        //leer el chichero hasta encontrar el codigo ;
        fichero = new RandomAccessFile(fhistorico, "rw");
        int n;
        String str="";
         
        try {
            fichero.seek(0); //nos situamos al principio
             do{
                str = fichero.readUTF();  //se lee  un entero del fichero
                n = fichero.readInt();  //se lee  un entero del fichero
                Historico h =new Historico(str,n);   
            }while (!(str.equals(texto)));
            //cuando coincida salimos del bucle 
            int acceso= byteint;//
            long pos= fichero.getFilePointer()-acceso;
            fichero.seek(pos);// nos ponemso en la posicion correcta
            // escribimos por encima
             //fichero.writeUTF(texto);  
            fichero.writeInt(numero); 
            fichero.close();
            
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
            fichero.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
    }

    }
    
    
    public static void  escribirFichero(String texto,int numero ){
   
        try {
            //se abre el fichero para lectura y escritura
            fichero = new RandomAccessFile(fhistorico, "rw");
           
            fichero.seek(fichero.length()); //nos situamos al final del fichero
            
            fichero.writeUTF(texto);  
            fichero.writeInt(numero);       //se escribe el entero
                 //se escribe el entero
           

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (fichero != null) {
                    fichero.close();
                }
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }
    
 
            

      public  static LinkedList <Historico>   mostrarFichero() throws FileNotFoundException, IOException {
        fichero = new RandomAccessFile(fhistorico, "rw");
        int n;
        String str;
          LinkedList <Historico> linkHistorico= new LinkedList <Historico> ();
        try {
            fichero.seek(0); //nos situamos al principio
            while (true) {
                str = fichero.readUTF();  //se lee  un entero del fichero
                n = fichero.readInt();  //se lee  un entero del fichero
                Historico h =new Historico(str,n);
                linkHistorico.add(h);
                h.toString();
                
                
            }
        } catch (EOFException e) {
            System.out.println("Fin de fichero");
            fichero.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    return linkHistorico; }
}