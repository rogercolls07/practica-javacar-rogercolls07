package org.JavaCar;

public class Roda{
    private String marca;
    private double diametre;

    public Roda(){
        this.marca= null;
        this.diametre= 0.0;
    }

    public Roda( String input_1, double input_2 ){
        this.marca= input_1;
        this.diametre= input_2;
    }

    public String getMarca(){ return this.marca; }
    public void setMarca( String input ){ this.marca= input; }

    public double getDiametre(){ return this.diametre; }
    public void setDiametre( double input ){ this.diametre= input; }

    @Override
    public String toString(){
        return "marca: "+this.marca+", diàmetre: "+this.diametre;
    }
}