package org.JavaCar;

public class Furgoneta extends Vehicle {
    private double capacitatCarga;

    public Furgoneta( String input1, String input2, String input3, double input4, double input5, Motor input6, Roda[] input7){
        super(input1, input2, input3, input4, input6, input7);
        this.capacitatCarga= input5;
    }

    @Override
    public double calcularPreu(int dies){
        double output = super.calcularPreu(dies);
        if( this.capacitatCarga > 1000 ){
            return (this.preuBase + 10) * dies;
        } else {
            return output;
        }
    }

    public double getCapacitatCarga() {
        return capacitatCarga;
    }

    @Override
    public String toString(){
        return super.toString()+"\033[38;2;255;170;85m"+"  ,  capacitat de carga: "+"\033[38;2;255;255;0m"+this.capacitatCarga+"\033[0m";
    }
}