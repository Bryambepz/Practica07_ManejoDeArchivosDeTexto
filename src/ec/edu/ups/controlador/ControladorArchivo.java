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
    private Random random;
    private long seed;
    
    public ControladorArchivo(String ruta){
	archivo = new File(ruta);
	random = new Random();
	generarMapa();
    }
    
    public ControladorArchivo(){
	archivo = new File("archivo.txt");
	random = new Random();
	generarMapa();
    }
    
    public void setRuta(String ruta){
	archivo = new File(ruta);
    }
    
    public String getRuta(){
	return archivo.getPath();
    }
    
    public void setSeed(long seed){
	this.seed = seed;
	random = new Random(seed);
    }
    
    public void generarMapa(){
	mapa = new HashMap<>();
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
	    if(mapa.containsKey(texto.charAt(i)))
		encriptado += mapa.get(texto.charAt(i));
	    else
		encriptado += texto.charAt(i);
	}
	return encriptado;
    }
    
    public String desencriptar(String texto){
	String desencriptado = "";
	for(int i = 0; i < texto.length(); i++){
	   if(mapa.containsKey(texto.charAt(i)))
		desencriptado += mapa.get(texto.charAt(i));
	    else
		desencriptado += texto.charAt(i);
	}
	return desencriptado;
    }
    
<<<<<<< HEAD
    public void guardar(String texto, File archivo){
	this.archivo = archivo;
=======
>>>>>>> 9b36e3284bde3b711f1d68a82691fd1cb7041b0f
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
    
<<<<<<< HEAD
    public String leer(File archivo){
	this.archivo = archivo;
	Scanner lectura = null;
=======
>>>>>>> 9b36e3284bde3b711f1d68a82691fd1cb7041b0f
	try {
	    lectura = new Scanner(archivo);
	    String texto = "";
	    while(lectura.hasNextLine())
		texto += lectura.nextLine()+"\n";
	    return texto;
	} catch (FileNotFoundException ex) {
	    Logger.getLogger(ControladorArchivo.class.getName()).log(Level.SEVERE, null, ex);
	} finally{
	    lectura.close();
	}
	return null;
    }
}
