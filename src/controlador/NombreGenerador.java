/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

/**
 * @file NombreGenerador.java
 * @brief Genera nombres completos aleatorios basados en listas de nombres y apellidos predefinidos.
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NombreGenerador {
    private final List<String> nombres;   ///< Lista de nombres disponibles para generar.
    private final List<String> apellidos; ///< Lista de apellidos disponibles para generar.

     /**
     * Constructor que inicializa las listas de nombres y apellidos con valores predefinidos.
     */
    public NombreGenerador() {
        nombres = new ArrayList<>();
        apellidos = new ArrayList<>();

        // Lista de 50 nombres
        nombres.add("Juan");
        nombres.add("María");
        nombres.add("Carlos");
        nombres.add("Laura");
        nombres.add("José");
        nombres.add("Ana");
        nombres.add("Pedro");
        nombres.add("Isabel");
        nombres.add("Jorge");
        nombres.add("Marta");
        nombres.add("Luis");
        nombres.add("Beatriz");
        nombres.add("Antonio");
        nombres.add("Raquel");
        nombres.add("David");
        nombres.add("Carmen");
        nombres.add("Sergio");
        nombres.add("Silvia");
        nombres.add("Felipe");
        nombres.add("Susana");
        nombres.add("Eduardo");
        nombres.add("Sandra");
        nombres.add("Ricardo");
        nombres.add("Patricia");
        nombres.add("Manuel");
        nombres.add("Alba");
        nombres.add("Francisco");
        nombres.add("Olga");
        nombres.add("Miguel");
        nombres.add("Cristina");
        nombres.add("Pedro");
        nombres.add("Mercedes");
        nombres.add("Raúl");
        nombres.add("Inés");
        nombres.add("Víctor");
        nombres.add("Lidia");
        nombres.add("Luis");
        nombres.add("Elena");
        nombres.add("Esteban");
        nombres.add("Paola");
        nombres.add("Antonio");
        nombres.add("Berta");
        nombres.add("Carlos");
        nombres.add("Ana");
        nombres.add("Marcos");

        // Lista de 50 apellidos
        apellidos.add("Pérez");
        apellidos.add("González");
        apellidos.add("Rodríguez");
        apellidos.add("López");
        apellidos.add("Martínez");
        apellidos.add("Sánchez");
        apellidos.add("García");
        apellidos.add("Hernández");
        apellidos.add("Fernández");
        apellidos.add("Jiménez");
        apellidos.add("Díaz");
        apellidos.add("Ruiz");
        apellidos.add("Moreno");
        apellidos.add("Álvarez");
        apellidos.add("Romero");
        apellidos.add("Torres");
        apellidos.add("Vázquez");
        apellidos.add("Ramírez");
        apellidos.add("Molina");
        apellidos.add("Suárez");
        apellidos.add("Jiménez");
        apellidos.add("Gómez");
        apellidos.add("Gil");
        apellidos.add("Navarro");
        apellidos.add("Muñoz");
        apellidos.add("Serrano");
        apellidos.add("Santos");
        apellidos.add("Costa");
        apellidos.add("Luna");
        apellidos.add("Morales");
        apellidos.add("Castro");
        apellidos.add("Cruz");
        apellidos.add("Ortega");
        apellidos.add("Escobar");
        apellidos.add("Pascual");
        apellidos.add("Gutiérrez");
        apellidos.add("Vega");
        apellidos.add("Cordero");
        apellidos.add("Santiago");
        apellidos.add("Cabrera");
        apellidos.add("Rivas");
        apellidos.add("Marín");
        apellidos.add("Arias");
        apellidos.add("Villarreal");
        apellidos.add("Jiménez");
    }

     /**
     * Genera un nombre completo aleatorio.
     * 
     * @return Un nombre completo formado por un primer nombre, un segundo nombre opcional,
     * y dos apellidos seleccionados aleatoriamente.
     */
    public String generarNombreCompleto() {
        Random rand = new Random();
        String primerNombre = nombres.get(rand.nextInt(nombres.size()));
        String segundoNombre = rand.nextInt(5) == 0 ? nombres.get(rand.nextInt(nombres.size())) : "";
        String apellido1 = apellidos.get(rand.nextInt(apellidos.size()));
        String apellido2 = apellidos.get(rand.nextInt(apellidos.size()));

        return primerNombre + " " + segundoNombre + " " + apellido1 + " " + apellido2;
    }
}

