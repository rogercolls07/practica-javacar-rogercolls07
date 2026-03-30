package org.JavaCar;

public class Moto extends Vehicle {
    private int cilindrada;

    public Moto( String input1, String input2, String input3, double input4, int input5, Motor input6, Roda[] input7){
        super(input1, input2, input3, input4, input6, input7);
        this.cilindrada= input5;
    }

    @Override
    public double calcularPreu(int dies){
        double output = super.calcularPreu(dies);
        if( this.cilindrada > 500 ){
            return (this.preuBase + 5) * dies;
        } else {
            return output;
        }
    }

    public int getCilindrada() {
        return cilindrada;
    }

    @Override
    public String toString(){
        return super.toString()+"\033[38;2;255;170;85m"+"  ,  cilindrada: "+"\033[38;2;255;255;0m"+this.cilindrada+"\033[0m";
    }
}