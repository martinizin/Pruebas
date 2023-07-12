import java.io.Serializable;
import java.io.*;

public class Vehiculo implements Serializable {
    private String marca;
    private String modelo;
    private int anio;

    public Vehiculo(String marca, String modelo, int anio) {
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Modelo: " + modelo + ", Año: " + anio;
    }
}

