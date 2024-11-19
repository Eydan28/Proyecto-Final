/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Alumno;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * @file ArchivoExportador.java
 * @brief Clase encargada de exportar los datos de los alumnos a un archivo CSV.
 */
public class ArchivoExportador {
    
     /**
     * Exporta una lista de alumnos a un archivo CSV.
     * 
     * @param alumnos Lista de objetos Alumno que se desean exportar.
     * @param rutaArchivo Ruta del archivo CSV donde se guardarán los datos.
     */

    public void exportarAArchivoCSV(List<Alumno> alumnos, String rutaArchivo) {
        try (FileWriter writer = new FileWriter(rutaArchivo)) {
            
            // Escribir el encabezado del archivo CSV
            writer.append("Nombre,Dirección,Edad,Número de Inscripción,Indicador Escolar\n");
            
            // Escribir los datos de cada alumno
            for (Alumno alumno : alumnos) {
                writer.append(alumno.getNombreCompleto())
                      .append(",")
                      .append(alumno.getDireccion())
                      .append(",")
                      .append(String.valueOf(alumno.getEdad()))
                      .append(",")
                      .append(alumno.getNumeroInscripcion())
                      .append(",")
                      .append(String.valueOf(alumno.getIndicadorEscolar()))
                      .append("\n");
            }
            System.out.println("Datos exportados correctamente a " + rutaArchivo);
        } catch (IOException e) {
            System.err.println("Error al exportar a CSV: " + e.getMessage());
        }
    }
}

