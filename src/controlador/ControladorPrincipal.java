/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Alumno;
import modelo.Asignatura;
import modelo.Direccion;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @file ControladorPrincipal.java
 * @brief Clase principal que gestiona las operaciones del sistema de gestión escolar, 
 * incluyendo la creación, actualización, eliminación y exportación de alumnos.
 */
public class ControladorPrincipal {
    private final List<Alumno> listaAlumnos; ///< Lista que almacena a los alumnos registrados.
    private List<Direccion> listaDirecciones; ///< Lista que almacena direcciones cargadas desde un archivo.
    private final NombreGenerador nombreGenerador; ///< Generador de nombres aleatorios.
    private DatosPersonalesGenerador datosGenerador; ///< Generador de datos personales aleatorios.
    private final GeneradorRegistrosAcademicos generadorAcademico; ///< Generador de registros académicos aleatorios.

     /**
     * Constructor que inicializa las listas y los generadores.
     */
    public ControladorPrincipal() {
        listaAlumnos = new ArrayList<>();
        listaDirecciones = new ArrayList<>();
        nombreGenerador = new NombreGenerador();
        generadorAcademico = new GeneradorRegistrosAcademicos();
    }

    /**
     * Carga las direcciones desde un archivo de texto y las almacena en la lista.
     * 
     * @param archivoPath Ruta del archivo que contiene las direcciones.
     */
    public void cargarDirecciones(String archivoPath) {
        DireccionLoader loader = new DireccionLoader();
        listaDirecciones = loader.cargarDirecciones(archivoPath);
        if (!listaDirecciones.isEmpty()) {
            System.out.println("Direcciones cargadas exitosamente: " + listaDirecciones.size());
            datosGenerador = new DatosPersonalesGenerador(listaDirecciones);
        } else {
            System.out.println("No se encontraron direcciones en el archivo.");
        }
    }

    /**
     * Agrega un nuevo alumno a la lista.
     * 
     * @param alumno Alumno a agregar.
     */
    public void agregarAlumno(Alumno alumno) {
        listaAlumnos.add(alumno);
    }

     /**
     * Crea un nuevo alumno de manera aleatoria según el semestre proporcionado.
     * 
     * @param semestre Semestre actual del alumno.
     * @return El objeto Alumno generado, o null si no hay direcciones cargadas.
     */
    public Alumno crearAlumno(int semestre) {
        if (datosGenerador == null) {
            System.out.println("Error: No se pueden generar alumnos, las direcciones no han sido cargadas.");
            return null;
        }

        Random rand = new Random();
        String nombreCompleto = nombreGenerador.generarNombreCompleto();
        Direccion direccion = datosGenerador.generarDireccion();
        int edad = datosGenerador.generarEdad(semestre);
        List<Asignatura> historialAcademico = generadorAcademico.generarHistorialAcademico(semestre);
        int creditosAcumulados = semestre * 5;
        int semestreIngreso = 1;
        int semestresSuspension = 0;
        String numeroInscripcion = new GeneradorNumeroInscripcion(listaAlumnos).generarNumeroInscripcion(semestre);

        return new Alumno(nombreCompleto, direccion.toString(), edad, numeroInscripcion, historialAcademico, creditosAcumulados, semestreIngreso, semestresSuspension);
    }

     /**
     * Actualiza los datos de un alumno existente.
     * 
     * @param numeroInscripcion Número de inscripción del alumno a actualizar.
     * @param alumnoActualizado Objeto Alumno con los nuevos datos.
     */
    public void actualizarAlumno(String numeroInscripcion, Alumno alumnoActualizado) {
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Alumno alumno = listaAlumnos.get(i);
            if (alumno.getNumeroInscripcion().equals(numeroInscripcion)) {
                listaAlumnos.set(i, alumnoActualizado);
                System.out.println("Alumno actualizado: " + alumnoActualizado.getNombreCompleto());
                return;
            }
        }
        System.out.println("No se encontró el alumno con número de inscripción: " + numeroInscripcion);
    }

     /**
     * Elimina un alumno de la lista.
     * 
     * @param numeroInscripcion Número de inscripción del alumno a eliminar.
     */
    public void eliminarAlumno(String numeroInscripcion) {
        for (int i = 0; i < listaAlumnos.size(); i++) {
            Alumno alumno = listaAlumnos.get(i);
            if (alumno.getNumeroInscripcion().equals(numeroInscripcion)) {
                listaAlumnos.remove(i);
                System.out.println("Alumno eliminado: " + alumno.getNombreCompleto());
                return;
            }
        }
        System.out.println("No se encontró el alumno con número de inscripción: " + numeroInscripcion);
    }

    /**
     * Exporta la lista de alumnos a un archivo CSV.
     * 
     * @param rutaArchivo Ruta donde se guardará el archivo CSV.
     */
    public void exportarAlumnosACSV(String rutaArchivo) {
        ArchivoExportador exportador = new ArchivoExportador();
        exportador.exportarAArchivoCSV(listaAlumnos, rutaArchivo);
    }

     /**
     * Muestra la lista de alumnos registrados en la consola.
     * Incluye detalles como nombre, dirección, edad, número de inscripción e indicador escolar.
     */
    public void mostrarAlumnos() {
        if (listaAlumnos.isEmpty()) {
            System.out.println("No hay alumnos registrados.");
            return;
        }

        System.out.println("\n=========== LISTADO DE ALUMNOS ===========");
        System.out.println("---------------------------------------------------------------");
        System.out.printf("%-25s %-30s %-5s %-20s %-15s\n", "Nombre", "Dirección", "Edad", "Número de Inscripción", "Indicador Escolar");
        System.out.println("---------------------------------------------------------------");

        for (Alumno alumno : listaAlumnos) {
            String direccion = alumno.getDireccion();
            if (direccion.length() > 30) {
                direccion = direccion.substring(0, 27) + "...";
            }

            System.out.printf("%-25s %-30s %-5d %-20s %-15.2f\n", 
                alumno.getNombreCompleto(), 
                direccion, 
                alumno.getEdad(), 
                alumno.getNumeroInscripcion(), 
                alumno.getIndicadorEscolar());
        }
        System.out.println("---------------------------------------------------------------");
    }
}
