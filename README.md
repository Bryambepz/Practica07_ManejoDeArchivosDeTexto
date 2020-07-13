# Practica07_ManejoDeArchivosDeTexto
Manejo de archivos de texto
# Lenguaje
- Java JDK 8.1
- IDE Netbeans Apache 11.3
# Librerias
 - java.io.File;
- java.io.FileNotFoundException;
- java.io.FileWriter;
- java.io.IOException;
- java.util.HashMap;
- java.util.Random;
- java.util.Scanner;
- java.util.logging.Level;
- java.util.logging.Logger;
- javax.swing.JFileChooser;
- javax.swing.JOptionPane;
## 1. Crear un repositorio en GitHub con el nombre de “Práctica07_ManejoDeArchivosDeTexto” 
- El repositorio que se creó se encuentra en el siguiente link de GitHub

https://github.com/Bryambepz/Practica07_ManejoDeArchivosDeTexto

## 2. ControladorArchivo
- En la clase ControladorArchivo están los métodos y atributos para el manejo del archivo de texto (guardar texto y leer el texto de un archivo), y también los métodos que nos sirven para encriptar y desencriptar un texto ingresado por el usuario.
Para encriptar se utiliza un diccionario que almacena caracteres, y lo llenamos generados números entre 32 y 126, que los convertimos a caracteres. Se generan dos números, el primero nos dirá el carácter que se cambiará, y el segundo nos dirá a qué carácter se convertirá. Estos dos números los añadimos al diccionario, el primero siendo la clave y el segundo siendo el valor, pero para que también podamos desencriptar, añadimos también el segundo como llave y el primero como valor, de esta forma nos será posible encriptar y desencriptar con el mismo diccionario.
- El codigo de la clase y el paquete controlador se encuentra en el siguiente link:

https://github.com/Bryambepz/Practica07_ManejoDeArchivosDeTexto/blob/master/src/ec/edu/ups/controlador/ControladorArchivo.java

## 3. Ventanas
#### - VentanaPrincipal
- Creamos un menú en el que se despliega opciones para encriptar o desencriptar un texto

![image](https://user-images.githubusercontent.com/64825176/87266403-d2d61d80-c48a-11ea-837a-d03aeaa32a3c.png)

#### - VentanaEncriptar
- En la ventana encriptar utilizaremos una caja de texto en el que ingresamos un path donde se encuentre un documento de texto, usamos la clase de java jFileChooser que permitirá mostrar una ventana para elegir un fichero, en este caso para encriptar un texto, que tengamos en algún fichero como un archivo de texto.

![image](https://user-images.githubusercontent.com/64825176/87266500-0fa21480-c48b-11ea-9da5-963009802574.png)

- Escribimos un texto en el JTextArea, y hacemos click sobre el botón encriptar, y se nos mostrará el texto encriptado en la parte de la derecha.

![image](https://user-images.githubusercontent.com/64825176/87266551-29dbf280-c48b-11ea-8bfd-a5d53162379c.png)

Después de elegir un fichero, o de escribir su nombre, para guardar el texto encriptado, se verificará si existe el archivo o no, si no existe se creará uno nuevo, pero si ya existe nos preguntará si queremos sobrescribirlo.

![image](https://user-images.githubusercontent.com/64825176/87266571-36f8e180-c48b-11ea-9fd1-2b7e254e9e64.png)

![image](https://user-images.githubusercontent.com/64825176/87266596-3eb88600-c48b-11ea-9e2d-dbe1ea4168ea.png)

- Después de guardar el texto en un archivo, se nos actualizará el JTextField con la ruta completa.

#### - VentanaDesencriptar
- Esta ventana tiene las mismas características el objetivo de esta ventana es elegir el archivo que se encripto y mediante un botón se desencripta el texto y se visualizará el texto que se tenía desde un inicio.

![image](https://user-images.githubusercontent.com/64825176/87266643-5d1e8180-c48b-11ea-9163-7a381ca7e173.png)

- Este es el funcionamiento de las ventanas encriptar o desencriptar utilizando la clase de java JFileChooser.
# RESULTADOS
- Conocer los métodos de la clase File para el manejo de archivos y directorios, y su uso para guardar texto dentro de un archivo. 
- Implementar el componente JFileChooser para seleccionar un archivo mediante interfaz, así también para guardarlo.

# CONCLUSIONES

- El componente JFileChooser nos permite un mejor manejo de archivos y directorios, ya que nos permite seleccionarlos mediante una interfaz gráfica que nos facilita al momento de abrir un archivo ya que lo podemos buscar fácilmente.
La clase File nos deja fácilmente crear directorios y archivos simples, así como el manejo de estos con los métodos ya implementados.

# RECOMENDACIONES
- Entender el funcionamiento de la clase File y sus diferentes métodos para el manejo de directorios y archivos.
Aprender sobre las clases para la lectura y escritura en archivos de texto simples, como lo son las clases FileWriter, FileReader y Scanner.
Comprender el funcionamiento del componente JFileChooser, y sus diferentes formas de funcionamiento, que nos permite guardar o abrir un archivo, seleccionado mediante la interfaz.

