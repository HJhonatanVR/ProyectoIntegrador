package pe.edu.upeu.dao;

import pe.edu.upeu.modelo.Abarrotes;
import pe.edu.upeu.modelo.Venta;
import pe.edu.upeu.utils.LeerFichero;
import pe.edu.upeu.utils.LeerTeclado;
import pe.edu.upeu.utils.UtilsX;

public class CrudDao extends ArchivoCrud{
    LeerFichero hjvr;
    UtilsX util=new UtilsX();
    LeerTeclado teclado=new LeerTeclado();
 
    public String generadorId(LeerFichero leerArcX, int numColum, String prefijo){
        int idX=1;
        Object[][] data=listarContenido(leerArcX);
        if(data!=null){
            idX=Integer.parseInt(data[data.length-1][numColum].toString().substring(1))+1;
        }
        return prefijo+""+idX;
    }

    public Object[][] AgregarProducto(){ 
            
        hjvr=new LeerFichero("Productos.txt");
        Abarrotes produc=new Abarrotes();   
        produc=new Abarrotes(); 
        produc.setCodigoProducto(teclado.read("", "Por Favor, ingrese codigo del producto")); 
        produc.setNProducto(teclado.read("", "Por Favor, ingrese el nombre del producto"));
        produc.setCantidad(teclado.read(0, "Por Favor, ingrese la cantindad del producto")); 
        produc.setUnitMed(teclado.read("","Ingrese Unidad Medida:"));
        produc.setPrecio(teclado.read(0.0, "Por Favor, ingrese el valor por unidad del producto")); 
            
        return agregarContenido(hjvr, produc); 
    }

    
    
    public Object[][] EditarProducto(){
        System.out.println("***************************MODIFICAR******************************");
        hjvr=new LeerFichero("Productos.txt");
        imprimirLista(listarContenido(hjvr));
        String dato=teclado.read("", "Ingrese el codigo del Producto:");
        Abarrotes modelo=new Abarrotes();
        modelo.setNProducto(teclado.read("","Corrija el nombre del producto "));
        modelo.setCantidad(teclado.read(0,"Corrija la cantidad del producto "));
        modelo.setPrecio(teclado.read(0.0,"Corrija el precio del producto "));
        Object[][] data=editarRegistro(hjvr, 0, dato, modelo);
        util.clearConsole();
        return data;
    }
    public Object[][] EliminarProducto(){
        System.out.println("************************Eliminar Producto**********************");
        hjvr=new LeerFichero("Productos.txt");
        imprimirLista(listarContenido(hjvr));
        String dato=teclado.read("", "Ingrese el codigo del Producto que desea eliminar:");
        Object[][] data=eliminarRegistros(hjvr, 0, dato);
        util.clearConsole();
        return data;
    }
    public Object[][] BuscarProducto(){
        System.out.println("***************************Buscar Producto*********************");
        hjvr=new LeerFichero("Productos.txt");
        imprimirLista(listarContenido(hjvr));
        String dato=teclado.read("", "Ingrese el codigo o nombre del Producto que desea Buscar:");
        Object[][] data=buscarContenido(hjvr, 0, dato);
        util.clearConsole();
        return data;
    }

    public Object[][] registrarVenta(){  
        System.out.println("****************Registrar Nueva Venta*************");                  
        hjvr=new LeerFichero("Productos.txt");   
        Object[][] venta=null;
        Object[][] listaProd=listarContenido(hjvr);
        if(listaProd!=null){
            for(int i=0;i<listaProd.length;i++){
                System.out.print(listaProd[i][0]+"="+listaProd[i][1]+" ("+listaProd[i][2]+"), ");
            }        
        System.out.println("");
        Venta pedTO=new Venta();
        hjvr=new LeerFichero("Ventas.txt");  
        pedTO.setNumeroVenta(generadorId(hjvr, 0, "v"));        
        pedTO.setIdProducto(teclado.read("", "Ingrese el Codigo del Producto:"));
        pedTO.setCantidad(teclado.read(0, "Ingrese la cantidad:"));
        hjvr=new LeerFichero("Productos.txt");   
        listaProd=buscarContenido(hjvr, 0, pedTO.getIdProducto());        
        pedTO.setPrecioUnitario(Double.parseDouble(listaProd[0][4].toString()));
        // pedTO.setFechaPed(formateador.format(new Date()));
        int cantidadProd=Integer.parseInt(listaProd[0][2].toString());
        pedTO.setNombreProducto(listaProd[0][1].toString());
        pedTO.setPrecioTotal(pedTO.getCantidad()*pedTO.getPrecioUnitario());        
        hjvr=new LeerFichero("Ventas.txt");
        String confirmar=teclado.read("S", "Desea confirmar la venta? S=Si, N=NO");
        if(confirmar.toUpperCase().charAt(0)=='S'){
           // System.out.println("ver:"+pedTO.getNumeroVenta());
            venta=agregarContenido(hjvr, pedTO);
            util.clearConsole();
            hjvr=new LeerFichero("Productos.txt");
            Abarrotes ab=new Abarrotes();
            ab.setCantidad(cantidadProd-pedTO.getCantidad());
            editarRegistro(hjvr, 0, pedTO.getIdProducto(), ab);
            System.out.println("La venta se registro correctamente!!");
        }else{
            confirmar=teclado.read("S", "Desea nuevamente realizar el Pedio? S=Si, N=NO");
            if(confirmar.toUpperCase().charAt(0)=='S'){
                util.clearConsole();                
                registrarVenta();
            }
        }
        }else{ 
            AgregarProducto(); 
            util.clearConsole();
            registrarVenta();
        }
        return venta;        
    }
    
}