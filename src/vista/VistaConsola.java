/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vista;

import controlador.ControladorPrincipal;
import modelo.Alumno;
import java.util.Scanner;

/**
 * @file VistaConsola.java
 * @brief Clase principal que implementa una interfaz de consola para la gestión de alumnos.
 * 
 * Este programa permite administrar una lista de alumnos generados por datos aleatorios,
 * interactuando con el usuario para agregar, mostrar, actualizar, eliminar alumnos, 
 * y exportar la información a un archivo CSV.
 */

public class VistaConsola {
    
    /**
     * Método principal que inicia el programa y contiene el menú interactivo.
     * @param args Argumentos de línea de comandos (no se utilizan).
     */
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ControladorPrincipal controlador = new ControladorPrincipal();

        // Cargar direcciones desde un archivo de texto
        String archivoDirecciones = "direcciones.txt";
        controlador.cargarDirecciones(archivoDirecciones);

        // Generar 1,000 alumnos aleatorios
        System.out.println("\nGenerando 1000 alumnos...");
        for (int i = 0; i < 1000; i++) {
            int semestre = (i % 10) + 1;
            Alumno alumno = controlador.crearAlumno(semestre);
            if (alumno != null) {
                controlador.agregarAlumno(alumno);
            }
        }

        // Menú interactivo
        while (true) {
            System.out.println("\n===== Sistema de Gestión Escolar =====");
            System.out.println("1. Agregar Alumno");
            System.out.println("2. Mostrar Alumnos");
            System.out.println("3. Actualizar Alumno");
            System.out.println("4. Eliminar Alumno");
            System.out.println("5. Exportar a CSV");
            System.out.println("6. Salir");
            System.out.print("Elija una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();  // Limpiar el buffer

            switch (opcion) {
                case 1 -> {
                    
                    /**
                     * Agrega un nuevo alumno solicitando el semestre al usuario.
                     */                    
                    
                    System.out.print("Ingrese el semestre del nuevo alumno (1-10): ");
                    int semestre = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer
                    Alumno alumno = controlador.crearAlumno(semestre);
                    controlador.agregarAlumno(alumno);
                    System.out.println("Alumno agregado: " + alumno.getNombreCompleto());
                }

                case 2 -> {
                    /**
                     * Muestra la lista de alumnos registrados.
                     */
                    System.out.println("\nListado de Alumnos:");
                    controlador.mostrarAlumnos();
                }

                case 3 -> {
                    
                    /**
                     * Actualiza la información de un alumno existente.
                     * Solicita el número de inscripción y los nuevos datos.
                     */                    
                    System.out.print("Ingrese el número de inscripción del alumno a actualizar: ");
                    String numeroInscripcion = scanner.nextLine();
                    System.out.println("Ingrese los nuevos datos del alumno:");
                    System.out.print("Nuevo semestre (1-10): ");
                    int semestreActualizado = scanner.nextInt();
                    scanner.nextLine();  // Limpiar el buffer

                    Alumno alumnoActualizado = controlador.crearAlumno(semestreActualizado);
                    controlador.actualizarAlumno(numeroInscripcion, alumnoActualizado);
                }

                case 4 -> {
                    // Eliminar un alumno
                    System.out.print("Ingrese el número de inscripción del alumno a eliminar: ");
                    String numeroInscripcion = scanner.nextLine();
                    controlador.eliminarAlumno(numeroInscripcion);
                }

                case 5 -> {
                    /**
                     * Exporta los registros de alumnos a un archivo CSV.
                     */                    
                    System.out.print("Ingrese el nombre del archivo CSV (ejemplo: alumnos.csv): ");
                    String rutaArchivo = scanner.nextLine();
                    controlador.exportarAlumnosACSV(rutaArchivo);
                }

                case 6 -> {
                    /**
                     * Finaliza el programa.
                     */                    
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                }

                default -> System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        
    }
}

