/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;
/**
 * @file Asignatura.java
 * @brief Representa una asignatura con un nombre y una calificación asociada.
 */
public class Asignatura {
    private final String nombre;    ///< Nombre de la asignatura.
    private final int calificacion; ///< Calificación obtenida en la asignatura.

    
     /**
     * Constructor para inicializar una asignatura con su nombre y calificación.
     * 
     * @param nombre Nombre de la asignatura.
     * @param calificacion Calificación obtenida en la asignatura.
     */
    public Asignatura(String nombre, int calificacion) {
        this.nombre = nombre;
        this.calificacion = calificacion;
    }

     /**
     * Obtiene el nombre de la asignatura.
     * 
     * @return El nombre de la asignatura.
     */
    public String getNombre() { return nombre; }
    
     /**
     * Obtiene la calificación de la asignatura.
     * 
     * @return La calificación obtenida.
     */
    public int getCalificacion() { return calificacion; }
}

