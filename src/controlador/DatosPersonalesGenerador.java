/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import modelo.Direccion;
import java.util.List;
import java.util.Random;

/**
 * @file DatosPersonalesGenerador.java
 * @brief Clase para generar datos personales de manera aleatoria, incluyendo edad y dirección.
 */
public class DatosPersonalesGenerador {
    private final List<Direccion> listaDirecciones; ///< Lista de direcciones disponibles para asignar aleatoriamente.

     /**
     * Constructor que inicializa la lista de direcciones.
     * 
     * @param listaDirecciones Lista de direcciones disponibles para generación aleatoria.
     */
    public DatosPersonalesGenerador(List<Direccion> listaDirecciones) {
        this.listaDirecciones = listaDirecciones;
    }

     /**
     * Genera una edad aleatoria basada en el semestre de ingreso.
     * 
     * @param semestre Semestre actual del alumno.
     *                 - Si el semestre es 5, la edad estará entre 19 y 28 años.
     *                 - Para otros semestres, estará entre 18 y 27 años.
     * @return Edad generada de manera aleatoria dentro del rango definido.
     */
    public int generarEdad(int semestre) {
        Random rand = new Random();
        int edad;
        if (semestre == 5) {
            edad = rand.nextInt(10) + 19;
        } else {
            edad = rand.nextInt(10) + 18;
        }
        return edad;
    }

     /**
     * Genera una dirección aleatoria seleccionada de la lista de direcciones.
     * 
     * @return Una dirección aleatoria tomada de la lista de direcciones disponibles.
     *         Si la lista está vacía, podría causar un error de índice fuera de rango.
     */
    public Direccion generarDireccion() {
        Random rand = new Random();
        return listaDirecciones.get(rand.nextInt(listaDirecciones.size()));
    }
}