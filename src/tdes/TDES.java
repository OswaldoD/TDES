/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tdes;

/**
 *
 * @author Phoenix
 * Esta clase se encarga de mantener la liga entre ambos tipos de codigo
 * 
 * 
 */
public class TDES {
    private String InputFile;
    private String key;
    private String OutputFile;
    private String tipo_llave;

    
    public native void pruebaConexion(String opcion, String nombreArchivo, String tipo_llave, String archivoSalida, String llave);
    static {
        System.loadLibrary("conexion");
    }
    
    public TDES(){
        
    }
    /**
     * @return the InputFile
     */
    public String getInputFile() {
        return InputFile;
    }

    /**
     * @param InputFile the InputFile to set
     */
    public void setInputFile(String InputFile) {
        this.InputFile = InputFile;
    }

    /**
     * @return the key
     */
    public String getKey() {
        return key;
    }

    /**
     * @param key the key to set
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * @return the OutputFile
     */
    public String getOutputFile() {
        return OutputFile;
    }

    /**
     * @param OutputFile the OutputFile to set
     */
    public void setOutputFile(String OutputFile) {
        this.OutputFile = OutputFile;
    }

    /**
     * @return the tipo_llave
     */
    public String getTipo_llave() {
        return tipo_llave;
    }

    /**
     * @param tipo_llave the tipo_llave to set
     */
    public void setTipo_llave(String tipo_llave) {
        this.tipo_llave = tipo_llave;
    }
    
}
