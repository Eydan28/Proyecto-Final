/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import java.util.List;
import java.util.Random;
import modelo.Alumno;

/**
 * @file GeneradorNumeroInscripcion.java
 * @brief Clase para generar números de inscripción únicos para estudiantes.
 */
public class GeneradorNumeroInscripcion {
    private final List<Alumno> listaAlumnos; ///< Lista de alumnos existente para garantizar unicidad en el número de inscripción.

     /**
     * Constructor que inicializa la lista de alumnos.
     * 
     * @param listaAlumnos Lista de alumnos actuales para asegurar que el número de inscripción sea único.
     */
    public GeneradorNumeroInscripcion(List<Alumno> listaAlumnos) {
        this.listaAlumnos = listaAlumnos;
    }

    /**
     * Genera un número de inscripción único basado en el semestre y la lista actual de alumnos.
     * 
     * @param semestre Semestre del alumno para incluirlo en el número de inscripción.
     * @return Un número de inscripción en el formato "AA-SS-NNNN", donde:
     * - AA: últimos dos dígitos del año de ingreso (2018 a 2023).
     * - SS: número del semestre, con ceros iniciales si es necesario (01 a 10).
     * - NNNN: número secuencial único basado en la cantidad de alumnos en la lista.
     */
    public String generarNumeroInscripcion(int semestre) {
        Random rand = new Random();
        int añoIngreso = rand.nextInt(6) + 2018;                                   // Genera un año entre 2018 y 2024
        String añoStr = String.valueOf(añoIngreso).substring(2);                   // Extrae los últimos 2 dígitos del año
        String semestreStr = String.format("%02d", semestre);                      // Formato de dos dígitos para el semestre
        String numeroSecuencial = String.format("%04d", listaAlumnos.size() + 1);  // Número secuencial de 4 dígitos


        return añoStr + "-" + semestreStr + "-" + numeroSecuencial;
    }
}

