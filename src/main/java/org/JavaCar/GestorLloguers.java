package org.JavaCar;
import java.util.ArrayList;
import java.util.List;

public class GestorLloguers {

    private GestorLloguers(){ throw new UnsupportedOperationException("GestorLloguers is a static class"); }

    static public double calcularIngressosTotals(List<Vehicle> vehicles, int dies){
        double total = 0.0;
        for (Vehicle v : vehicles) {
            total += v.calcularPreu(dies);
        }
        return total;
    }

    static public List<Vehicle> filtrarPerPreu(List<Vehicle> vehicles, double preuMax){
        List<Vehicle> vehiclesFiltrats = new ArrayList<>();
        for (Vehicle v : vehicles) {
            if (v.calcularPreu(1) <= preuMax) {
                vehiclesFiltrats.add(v);
            }
        }
        return vehiclesFiltrats;
    }
}