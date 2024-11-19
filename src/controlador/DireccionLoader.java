/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Direccion;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @file DireccionLoader.java
 * @brief Clase para cargar objetos de tipo `Direccion` desde un archivo de texto.
 */
public class DireccionLoader {

    /**
     * Carga una lista de direcciones desde un archivo de texto.
     * 
     * @param archivoPath Ruta del archivo de texto que contiene las direcciones.
     *                     Cada línea del archivo debe estar en el formato:
     *                     "calle, colonia, ciudad, estado, códigoPostal".
     * @return Una lista de objetos `Direccion` creados a partir del archivo. Si hay un error en el archivo,
     *         se devuelve una lista vacía.
     * 
     * Este método ignora las líneas que no tengan exactamente cinco elementos separados por comas.
     * En caso de error de lectura, se imprime un mensaje de error.
     */    
    public List<Direccion> cargarDirecciones(String archivoPath) {
        List<Direccion> direcciones = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivoPath))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] partes = linea.split(","); // Separar por comas
                if (partes.length == 5) {
                    String calle = partes[0].trim();
                    String colonia = partes[1].trim();
                    String ciudad = partes[2].trim();
                    String estado = partes[3].trim();
                    String codigoPostal = partes[4].trim();
                    Direccion direccion = new Direccion(calle, colonia, ciudad, estado, codigoPostal);
                    direcciones.add(direccion);
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo de direcciones: " + e.getMessage());
        }
        return direcciones;
    }
}

