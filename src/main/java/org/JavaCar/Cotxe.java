package org.JavaCar;

public class Cotxe extends Vehicle {
    private int nombrePlaces;

    public Cotxe( String input1, String input2, String input3, double input4, int input5, Motor input6, Roda[] input7){
        super(input1, input2, input3, input4, input6, input7);
        this.nombrePlaces= input5;
    }

    public int getNombrePlaces() { return nombrePlaces; }

    @Override
    public String toString(){
        return super.toString()+"\033[38;2;255;170;85m"+"  ,  places: "+"\033[38;2;255;255;0m"+this.nombrePlaces+"\033[0m";
    }
}