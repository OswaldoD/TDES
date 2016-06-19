/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Phoenix
 * Esta clase se encarga de cargar el archivo
 * 
 */
public class FileManager {
    
    
    
    public FileManager(){
        
    }
    
    public String loadFile(String ruta){
        try{
            BufferedReader entrada = new BufferedReader(new FileReader(ruta));
	    String lectura;
            String line = "";
            while((lectura = entrada.readLine()) != null){
                line += lectura;
            }
            entrada.close();
       	    return line;
        } catch(IOException e){
            e.printStackTrace();
			return "";
	}
    }
    
}
