/*DESCRIPCIÓN DEL PROGRAMA:El programa "AlmacenarVehiculos" tiene la función
de almacenar la información de varios vehículos en un archivo de texto.
El programa inicia creando tres objetos de vehículo con información específica,
como la marca, el modelo y el año.
Estos objetos de vehículo se almacenan en un array llamado "vehiculos".
Luego, el programa guarda el contenido del array "vehiculos" en un archivo
de texto.
La información de los vehículos se guarda en el archivo especificado,
que se nombra "vehiculos.txt". Después de almacenar los vehículos en el
archivo, el programa recupera la información leyendo el archivo.*/

import java.io.*;
public class AlmacenarVehiculos {
    public static void main(String[] args) {
        // Crear los objetos de vehículo
        Vehiculo vehiculo1 = new Vehiculo("Toyota", "Corolla", 2022);
        Vehiculo vehiculo2 = new Vehiculo("Honda", "Civic", 2021);
        Vehiculo vehiculo3 = new Vehiculo("Ford", "Mustang", 2023);

        // Array de vehículos
        Vehiculo[] vehiculos = {vehiculo1, vehiculo2, vehiculo3};

        // Nombre del archivo
        String nombreArchivo = "vehiculos.txt";

        try {
            // Crear un ObjectOutputStream para escribir objetos en el archivo
            ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(nombreArchivo));

            // Escribir el array de vehículos en el archivo
            outputStream.writeObject(vehiculos);

            // Cerrar el ObjectOutputStream
            outputStream.close();

            System.out.println("La información de los vehículos se ha almacenado en el archivo " + nombreArchivo);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        // Leer la información de los vehículos desde el archivo
        try {
            // Crear un ObjectInputStream para leer objetos desde el archivo
            ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(nombreArchivo));

            // Leer el array de vehículos desde el archivo
            Vehiculo[] vehiculosLeidos = (Vehiculo[]) inputStream.readObject();

            // Cerrar el ObjectInputStream
            inputStream.close();

            // Mostrar la información de los vehículos leídos
            for (Vehiculo vehiculo : vehiculosLeidos) {
                System.out.println(vehiculo);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
