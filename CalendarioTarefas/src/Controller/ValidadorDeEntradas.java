package Controller;

import java.util.Scanner;

public class ValidadorDeEntradas {

    public static String validaSeELetra(String mensagem){
        Scanner ler = new Scanner(System.in);
        String valorAValidar = null;
        boolean valido = false;
        
        while(valido == false){
            System.out.println(mensagem);
            valorAValidar = ler.nextLine();
            
            if(valorAValidar.equals("") || valorAValidar.equals(" ")){
                valido = true;
            }
        }
        
        return valorAValidar;

    }
    

    public static String validaSeENumero(String mensagem){
        Scanner ler = new Scanner(System.in);
        String valorAValidar = null;
        boolean valido = false;
        
        while(valido == false){
            System.out.println(mensagem);
            valorAValidar = ler.nextLine();
            
            if(valorAValidar.matches("[0-9]+") == true){
                valido = true;
            }
        }
        
        return valorAValidar;

    }

}
