/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.List;

/**
 * @file Alumno.java
 * @brief Representa a un alumno con datos personales, académicos y un historial de asignaturas.
 */
public class Alumno {
    private final String nombreCompleto;               ///< Nombre completo del alumno.
    private final String direccion;                    ///< Dirección del alumno.
    private final int edad;                            ///< Edad del alumno.
    private final String numeroInscripcion;            ///< Número de inscripción único del alumno.
    private final List<Asignatura> historialAcademico; ///< Lista de asignaturas cursadas por el alumno.
    private final int creditosAcumulados;              ///< Créditos acumulados por el alumno.
    private final int semestreIngreso;                 ///< Semestre en el que el alumno ingresó.
    private final int semestresSuspension;             ///< Número de semestres en los que el alumno estuvo suspendido.


    
     /**
     * Constructor para inicializar un alumno con todos sus datos.
     * 
     * @param nombreCompleto Nombre completo del alumno.
     * @param direccion Dirección del alumno.
     * @param edad Edad del alumno.
     * @param numeroInscripcion Número único de inscripción del alumno.
     * @param historialAcademico Lista de asignaturas cursadas por el alumno.
     * @param creditosAcumulados Créditos acumulados por el alumno.
     * @param semestreIngreso Semestre en el que el alumno ingresó.
     * @param semestresSuspension Número de semestres suspendidos.
     */
    public Alumno(String nombreCompleto, String direccion, int edad, String numeroInscripcion, List<Asignatura> historialAcademico, int creditosAcumulados, int semestreIngreso, int semestresSuspension) {
        this.nombreCompleto = nombreCompleto;
        this.direccion = direccion;
        this.edad = edad;
        this.numeroInscripcion = numeroInscripcion;
        this.historialAcademico = historialAcademico;
        this.creditosAcumulados = creditosAcumulados;
        this.semestreIngreso = semestreIngreso;
        this.semestresSuspension = semestresSuspension;
    }

     /**
     * Obtiene el nombre completo del alumno.
     * 
     * @return El nombre completo del alumno.
     */
    public String getNombreCompleto() { return nombreCompleto; }
    
      /**
     * Obtiene la dirección del alumno.
     * 
     * @return La dirección del alumno.
     */
    public String getDireccion() { return direccion; }
    
     /**
     * Obtiene la edad del alumno.
     * 
     * @return La edad del alumno.
     */
    public int getEdad() { return edad; }
    
    /**
     * Obtiene el número de inscripción del alumno.
     * 
     * @return El número de inscripción.
     */
    public String getNumeroInscripcion() { return numeroInscripcion; }
    
    /**
     * Obtiene el historial académico del alumno.
     * 
     * @return La lista de asignaturas cursadas.
     */
    public List<Asignatura> getHistorialAcademico() { return historialAcademico; }
    
     /**
     * Obtiene los créditos acumulados por el alumno.
     * 
     * @return Los créditos acumulados.
     */
    public int getCreditosAcumulados() { return creditosAcumulados; }
    
     /**
     * Obtiene el semestre en el que el alumno ingresó.
     * 
     * @return El semestre de ingreso.
     */
    public int getSemestreIngreso() { return semestreIngreso; }
    
    /**
     * Obtiene el número de semestres en los que el alumno estuvo suspendido.
     * 
     * @return El número de semestres suspendidos.
     */
    public int getSemestresSuspension() { return semestresSuspension; }
    
    /**
     * Calcula el indicador escolar del alumno.
     * El indicador escolar se basa en el promedio de calificaciones, los créditos acumulados,
     * y el impacto de los semestres suspendidos.
     * 
     * @return El indicador escolar calculado.
     */
    public double getIndicadorEscolar() {
        double promedio = historialAcademico.stream().mapToInt(Asignatura::getCalificacion).average().orElse(0.0);
        return promedio + creditosAcumulados - semestresSuspension;
    }
}

