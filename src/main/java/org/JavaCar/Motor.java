package org.JavaCar;

public class Motor {
    private String tipus;
    private int potencia;
    private String type;

    public Motor(){
        this.tipus= null;
        this.potencia= 0;
    }

    public Motor(String input_1, int input_2){
        this.tipus= input_1;
        this.potencia= input_2;
    }

    public String getTipus(){ return this.tipus; }
    public void setTipus(String input){ this.tipus= input; }

    public int getPotencia(){ return this.potencia; }
    public void setPotencia(int input){ this.potencia= input; }

    @Override
    public String toString(){
        return "tipus: "+this.tipus+", potència: "+this.potencia;
    }
}


