package org.JavaCar;
import java.util.Arrays;
import java.util.Locale;

public abstract class Vehicle implements Llogable {

    protected String matricula;
    protected String marca;
    protected String model;
    protected double preuBase;
    protected Motor motor;
    protected Roda[] rodes;
    protected String etiquetaAmbiental;
    protected int year;
    protected String type;

    Vehicle( String input1, String input2, String input3, double input4, Motor input5, Roda[] input6){
        this.matricula= input1;
        this.marca= input2;
        this.model= input3;
        this.preuBase= input4;
        this.motor= input5;
        this.rodes= input6;
        this.etiquetaAmbiental= "Sense etiqueta";
        this.year= 2026;
        this.type= "vehicle";
    }

    public String getMatricula() { return matricula; }
    public void setMatricula(String input) { this.matricula = input; }

    public String getMarca() { return marca; }
    public void setMarca(String input) { this.marca = input; }

    public String getModel() { return model; }
    public void setModel(String input) { this.model = input; }

    public double getPreuBase() { return preuBase; }
    public void setPreuBase(double input) { this.preuBase = input; }

    public Motor getMotor() { return motor; }
    public void setMotor(Motor input) { this.motor = input; }

    public Roda[] getRodes() { return rodes; }
    public void setRodes(Roda[] input) { this.rodes = input; }

    public String getEtiquetaAmbiental() { return this.etiquetaAmbiental; }
    public void setEtiquetaAmbiental(String input) { this.etiquetaAmbiental = input; }

    public int getYear(){ return this.year; }
    public void setYear(int input){ this.year= input; }

    public String getType(){ return this.type; }
    public void setType(String input){ this.type= input; }


    public void setTypesetYear(String input_1, int input_2){
        this.type= input_1;
        this.year= input_2;
    }
    public void setTheLabel(){
        Motor x= this.motor;
        String xx= this.motor.getTipus();
        int y= this.year;
        String z= "Sensa etiqueta";
        if( x==null || xx==null ){ z= "sense Motor"; }

        if (xx.equals("elèctric") || xx.equals("phev")) { z= "0 Emissions (Blava)"; }
        else if(xx.equals("híbrid") || xx.equals("gnc") || xx.equals("glp")) { z= "ECO (verda i blava)"; }
        else if( xx.equals("gasolina") ){
            if ( y >= 2006 ) { z= "C (verda)"; }
            else if ( y >= 2000 ) { z= "B (groga)"; }
            else { z= "sense etiqueta (A)"; }
        }
        else if ( xx.equals("diesel") ) {
            if ( y >= 2014 ) { z= "C (verda)"; }
            else if ( y >= 2006 ) { z= "B (groga)"; }
            else { z= "sense etiqueta (A)"; }
        }
        else { z= "desconegut"; }

        this.etiquetaAmbiental= z;
    }
    public double calcularPreu(int dies){ return (this.preuBase * dies); }


    @Override
    public String toString() {
        String motor_str= ( this.motor!=null ) ? this.motor.toString() : "Cap motor";
        String rodes_str= ( this.rodes!=null ) ? Arrays.toString(this.rodes) : "Sense rodes";
        return "\033[38;2;255;170;85m"+"Tipus: "+"\033[38;2;255;255;0m" + this.type +
                "\033[38;2;255;170;85m"+"  ,  matrícula: "+"\033[38;2;255;255;0m" + this.matricula +
                "\033[38;2;255;170;85m"+"  ,  marca: "+"\033[38;2;255;255;0m" + this.marca +
                "\033[38;2;255;170;85m"+"  ,  model: "+"\033[38;2;255;255;0m" + this.model +
                "\033[38;2;255;170;85m"+"  ,  any de fabricació: "+"\033[38;2;255;255;0m" + this.year +
                "\033[38;2;255;170;85m"+"  ,  preu base: "+"\033[38;2;255;255;0m"+ this.preuBase +
                "\033[38;2;255;170;85m"+"  ,  motor: "+"\033[38;2;255;255;0m"+ motor_str +
                "\033[38;2;255;170;85m"+"  ,  rodes: "+"\033[38;2;255;255;0m" + rodes_str +
                "\033[38;2;255;170;85m"+"  ,  etiqueta ambiental: "+"\033[38;2;255;255;0m"+ this.etiquetaAmbiental +
                "\033[0m";
    }
}