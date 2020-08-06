package pe.edu.upeu.grupo5;

import javax.swing.JOptionPane;

import pe.edu.upeu.dao.ArchivoCrud;
import pe.edu.upeu.dao.CrudDao;
import pe.edu.upeu.utils.LeerFichero;
import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.utils.UtilsX;


public class DelSur {
    static LeerTeclado teclado=new LeerTeclado();
    static LeerFichero hjvr;  
    static ArchivoCrud dao=new ArchivoCrud(); 
    static UtilsX utilx=new UtilsX();
    

    public static void main( String[] args ){
      System.out.println("           ***********************");
      System.out.println("           *    DELSUR - PUNO    *");
      System.out.println("           ***********************");
      char opcion='S';
      
      do{ 
        String user=teclado.read("","Por Favor, Ingrese su usuario:");
        String pass=teclado.read("","Por Favor, Ingrese su contraseña:");
        if(user.equals("")||pass.equals("")){
          JOptionPane.showMessageDialog(null, "Debe llenar todos los campos");
          }else if(user.equals("Jhonatan") && pass.equals("ciclo1")||user.equals("Lenin") && pass.equals("ciclo1")||user.equals("Yhoel") && pass.equals("ciclo1")||user.equals("Diego") && pass.equals("ciclo1")){
            System.out.println("");                    
                
                int numAlgoritm=1;  
               
                do{            
                   numAlgoritm=teclado.read(0,
                    "BIENVENIDO A DELSUR ABARROTES, QUE DESEA HACER: \n"+
                    "-----------------------------------------------\n\n"+
                    "1: Agregar Producto\n"+
                    "2: Modificar Producto \n"+
                    "3: Buscar Producto\n"+
                    "4: Eliminar Producto\n"+
                    "5: Regristrar Venta\n"
                    
                    );    
    
                    CrudDao editor;
                    switch(numAlgoritm){
                        case 1:  
                           editor=new CrudDao();
                           editor.imprimirLista(editor.AgregarProducto());
                        break;  
                        case 2:
                            utilx.clearConsole();
                            editor=new CrudDao();
                            editor.imprimirLista(editor.EditarProducto());
                        break;
                        case 3:
                            utilx.clearConsole();
                            editor=new CrudDao();
                            editor.imprimirLista(editor.BuscarProducto());
                        break;
                        case 4:
                            utilx.clearConsole();
                            editor=new CrudDao();
                            editor.imprimirLista(editor.EliminarProducto());
                        break;
                        case 5:
                            utilx.clearConsole();
                            editor=new CrudDao();
                            editor.imprimirLista(editor.registrarVenta());
                        break;
                       
                        default: System.out.println("La opcion No existe!!"); break;
                    }            
                    opcion=teclado.read(' ', "Desea continuar ejecutando otra opción S/N?");
                }while(opcion=='S' || opcion=='s');   
            
        }else{
            System.out.println("El usuario y/o la contraseña son incorrectas!!");  
            System.out.println("");
          }    
        
      }while(opcion==('S')||opcion==('s'));
        

    }
    

}