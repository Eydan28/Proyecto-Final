/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 * @file Direccion.java
 * @brief Representa la dirección de un alumno con detalles como calle, colonia, ciudad, estado y código postal.
 */
public class Direccion {
    private final String calle;         ///< Calle de la dirección
    private final String colonia;       ///< Colonia de la dirección
    private final String ciudad;        ///< Ciudad de la dirección
    private final String estado;        ///< Estado de la dirección
    private final String codigoPostal;  ///< Código postal de la dirección

     /**
     * Constructor para inicializar una dirección con todos sus campos.
     * 
     * @param calle Calle de la dirección.
     * @param colonia Colonia de la dirección.
     * @param ciudad Ciudad de la dirección.
     * @param estado Estado de la dirección.
     * @param codigoPostal Código postal de la dirección.
     */
    
    public Direccion(String calle, String colonia, String ciudad, String estado, String codigoPostal) {
        this.calle = calle;
        this.colonia = colonia;
        this.ciudad = ciudad;
        this.estado = estado;
        this.codigoPostal = codigoPostal;
    }

    
     /**
     * Convierte la dirección a una representación en formato de texto.
     * 
     * @return Una cadena con el formato: "calle, colonia, ciudad, estado, código postal".
     */
    @Override
    public String toString() {
        return calle + ", " + colonia + ", " + ciudad + ", " + estado + ", " + codigoPostal;
    }
}

