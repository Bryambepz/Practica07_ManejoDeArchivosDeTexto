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
    /**
     * Atributos de la clase
     * File archivo: Sirve para el manejo del archivo de texto
     * HashMap mapa: Diccionario para la encriptación del texto
     * Random random: Objeto de la clase Random para generar números aleatorios
     */
    private File archivo;
    private HashMap<Character,Character> mapa;
    private Random random;
    private long seed;
    
    /**
     * Constructor de la clase ControladorArchivo
     * @param ruta Ruta del archivo que se va a manejar
     */
    public ControladorArchivo(String ruta){
	archivo = new File(ruta);
	random = new Random();
	seed = random.nextLong();
	random = new Random(seed);
	generarMapa();
    }
    
    /**
     * Constructor por defecto de la clase.
     * Establece por defecto un archivo "archivo.txt" dentro del proyecto para ser manejado
     */
    public ControladorArchivo(){
	archivo = new File("archivo.txt");
	random = new Random();
	seed = random.nextLong();
	random = new Random(seed);
	generarMapa();
    }
    
    /**
     * Setter del atributo ruta. Representa la ruta del archivo a manejar
     * @param ruta Ruta del archivo
     */
    public void setRuta(String ruta){
	archivo = new File(ruta);
    }
    
    /**
     * Getter del atributo ruta. Representa la ruta del archivo a manejar
     * @return String con la ruta completa del archivo que se está manejando
     */
    public String getRuta(){
	return archivo.getPath();
    }
    
    /**
     * Setter del atributo seed. Semilla con la que se va a generar los números aleatorios
     * @param seed Semilla para generar números aleatorios
     */
    public void setSeed(long seed){
	random = new Random(seed);
    }
    
    /**
     * Método para ññenar el diccionario con carateres para la encriptación de un texto
     * Se generan dos números entre 32 y 126, el primero representa la llave, y el segundo el valor.
     * Los números se transforman a caracteres y se añmacenan en el diccionario
     */
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
    
    /**
     * Método para encriptar un texto
     * @param texto String con el texto a encriptar
     * @return String con el texto encriptado
     */
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
    
    /**
     * Método para desencriptar un texto
     * @param texto String con el texto a desencriptar
     * @return String con el texto desencriptado
     */
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
    
    /**
     * Encripta un texto y lo guarda en un archivo seleccionado previamente
     * @param texto String con el texto a encriptar y guardar
     * @param archivo File con el archivo a guardar
     */
    public void guardar(String texto, File archivo){
	this.archivo = archivo;
	FileWriter escritura = null;
	String txt = seed+"\n";
	try {
	    txt += encriptar(texto);
	    escritura = new FileWriter(archivo);
	    escritura.write(txt);
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
    
    /**
     * Lee un archivo de texto y retorna sus contenidos en forma de String
     * @param archivo File con el archivo a leer
     * @return String con los datos del archivo
     */
    public String leer(File archivo){
	this.archivo = archivo;
	Scanner lectura = null;
	try {
	    lectura = new Scanner(archivo);
	    String texto = lectura.nextLine();
	    setSeed(Long.parseLong(texto));
	    generarMapa();
	    texto = "";
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
