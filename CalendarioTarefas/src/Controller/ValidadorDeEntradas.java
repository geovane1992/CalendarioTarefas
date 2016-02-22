package Controller;

import java.util.Scanner;

public class ValidadorDeEntradas {

    public static boolean validaSeELetra(String caracter){
        
        return caracter.contains("^[a-Z]");

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
