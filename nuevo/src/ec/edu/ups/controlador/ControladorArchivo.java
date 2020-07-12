package ec.edu.ups.controlador;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorArchivo {
    private File archivo;
    private HashMap<Character,Character> mapa;
    
    public ControladorArchivo(String ruta){
	archivo = new File(ruta);
	generarMapa();
    }
    
    public ControladorArchivo(){
	archivo = new File("archivo.txt");
	generarMapa();
    }
    
    public void setRuta(String ruta){
	archivo = new File(ruta);
    }
    
    public String getRuta(){
	return archivo.getPath();
    }
    
    public void generarMapa(){
	generarMapa(0);
    }
    
    public void generarMapa(long seed){
	mapa = new HashMap<>();
	Random random = new Random(seed);
	while(mapa.size() < 94){
	    char valor1 = (char)(random.nextInt(95)+32);
	    char valor2 = (char)(random.nextInt(95)+32);
	    if(!mapa.containsKey(valor1) && !mapa.containsKey(valor2)){
		mapa.put(valor1, valor2);
		mapa.put(valor2, valor1);
	    }
	}
    }
    
    public String encriptar(String texto){
	String encriptado = "";
	for(int i = 0; i < texto.length(); i++){
	    encriptado += mapa.get(texto.charAt(i));
	}
	return encriptado;
    }
    
    public String desencriptar(String texto){
	String desencriptado = "";
	for(int i = 0; i < texto.length(); i++){
	    desencriptado += mapa.get(texto.charAt(i));
	}
	return desencriptado;
    }
    
    public void guardar(String texto, String ruta){
        archivo = new File(ruta);
	FileWriter escritura = null;
	try {
	    texto = encriptar(texto);
	    escritura = new FileWriter(archivo);
	    escritura.write(texto);
	} catch (IOException ex) {
	    Logger.getLogger(ControladorArchivo.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		escritura.close();
	    } catch (IOException ex) {
		Logger.getLogger(ControladorArchivo.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    public void guardarTextp(String texto, String ruta){
        archivo = new File(ruta);
	FileWriter escritura = null;
	try {
	    //texto = encriptar(texto);
	    escritura = new FileWriter(archivo);
	    escritura.write(texto);
	} catch (IOException ex) {
	    Logger.getLogger(ControladorArchivo.class.getName()).log(Level.SEVERE, null, ex);
	} finally {
	    try {
		escritura.close();
	    } catch (IOException ex) {
		Logger.getLogger(ControladorArchivo.class.getName()).log(Level.SEVERE, null, ex);
	    }
	}
    }
    
    public String leer(){
	try {
	    Scanner lectura = new Scanner(archivo);
	    String texto = lectura.nextLine();
	    texto = desencriptar(texto);
	    return texto;
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(ControladorArchivo.class.getName()).log(Level.SEVERE, null, ex);
	}
	return null;
    }
}
