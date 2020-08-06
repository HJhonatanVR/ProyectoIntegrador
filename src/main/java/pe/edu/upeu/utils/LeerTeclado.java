package pe.edu.upeu.utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;


public class LeerTeclado {
    BufferedReader leer=new BufferedReader(new InputStreamReader(System.in));
    
    public int read(int dato, String mensaje){
        System.out.println(mensaje);
        try {
            dato=Integer.parseInt(leer.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dato;
    }

    public String read(String dato, String mensaje){
        System.out.println(mensaje);
        try {
            dato=leer.readLine();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dato;

    }

    public double read(double dato, String mensaje){
        System.out.println(mensaje);
        try {
            dato=Double.parseDouble(leer.readLine());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dato;
    }

    public char read(char dato, String mensaje){
        System.out.println(mensaje);
        try {
            dato=leer.readLine().charAt(0);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return dato;
    }
}