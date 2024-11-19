/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Asignatura;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @file GeneradorRegistrosAcademicos.java
 * @brief Clase para generar historiales académicos aleatorios de estudiantes basados en el semestre.
 */
public class GeneradorRegistrosAcademicos {
    private final List<String> asignaturas; ///< Lista de nombres de asignaturas disponibles.

     /**
     * Constructor que inicializa la lista de asignaturas.
     * Las asignaturas tienen nombres predefinidos del tipo "Asignatura X".
     */
    public GeneradorRegistrosAcademicos() {
        asignaturas = new ArrayList<>();
        for (int i = 1; i <= 50; i++) {
            asignaturas.add("Asignatura " + i);
        }
    }

    /**
     * Genera un historial académico aleatorio para un estudiante en un semestre específico.
     * 
     * @param semestre Semestre actual del estudiante (determina el máximo de materias cursadas).
     * @return Una lista de asignaturas con calificaciones generadas aleatoriamente.
     * 
     * El número de materias generadas varía de 5 al máximo permitido para el semestre
     * (5 por semestre, es decir, para el semestre 2, máximo 10 materias).
     * Las calificaciones son números enteros entre 5 y 10.
     */
    public List<Asignatura> generarHistorialAcademico(int semestre) {
        Random rand = new Random();
        
        // Determina el número máximo de materias en función del semestre
        int maxMaterias = semestre * 5;  // Máximo de materias cursadas
        int numAsignaturas = rand.nextInt(maxMaterias - 4) + 5; // Entre 5 y el máximo permitido

        List<Asignatura> historialAcademico = new ArrayList<>();
        for (int i = 0; i < numAsignaturas; i++) {
                    // Genera una asignatura aleatoria con calificación entre 5 y 10
            historialAcademico.add(new Asignatura(asignaturas.get(rand.nextInt(asignaturas.size())), rand.nextInt(6) + 5));
        }
        return historialAcademico;
    }
}

