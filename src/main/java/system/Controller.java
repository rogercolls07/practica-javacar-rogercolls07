package system;
import java.util.List;
import java.util.ArrayList;

public class Controller {

    private Controller(){ throw new UnsupportedOperationException("Controller is a static class"); }

    private static List<org.JavaCar.Vehicle> storage= new ArrayList<>();
    private static void list_display(List<org.JavaCar.Vehicle> input_1, String input_2){
        if( storage.size()==0 ){ Utils.text(input_2,255,85,0,true); }
        else{
            for( int i=0;i<input_1.size();i++ ){
                org.JavaCar.Vehicle v= input_1.get(i);
                Utils.text(""+"Vehicle N° "+"\033[38;2;255;255;170m"+(i+1)+"\033[38;2;255;170;0m"+" : "+v.toString(),255,170,0,true);
                Utils.b();
            }
        }
    }

    public static void menu(){
        Utils.clear();
        boolean auto_shutdown= false;
        MenuConsole.menu_signin();
        String input_signin;
        String input_main;
        do{
            input_signin= Utils.input(true);
            switch(input_signin){
                case"1":

                    boolean signin_access;
                    int signin_attempt= 0;
                    do{
                        Utils.br();
                        signin_access= Utils.signin();
                        if(!signin_access){
                            signin_attempt++;
                            Utils.text("Error de registre (intent "+signin_attempt+"/3)",255,85,0,true);
                            Utils.fx_error();
                        }
                        if( signin_attempt==3 ){ signin_access= true; }
                    }while( !signin_access );
                    if( signin_attempt!=3 ){

                        boolean success= false;
                        do{

                            Utils.br();
                            MenuConsole.menu_main();
                            if( success==true ){ MenuConsole.menu_main_success(); }

                            input_main= Utils.input(true);
                            switch(input_main){

                                case"1":
                                    String input_main_1;
                                    do{
                                        Utils.br();
                                        MenuConsole.menu_main_1();
                                        input_main_1= Utils.input(true);

                                        if( input_main_1.matches("[1-3]") ){
                                            String vehicle;
                                            if( input_main_1.equals("1") ){ vehicle="cotxe"; }
                                            else if( input_main_1.equals("2") ){ vehicle="moto"; }
                                            else{ vehicle= "furgoneta"; }
                                            Utils.br();
                                            MenuConsole.menu_main_1_(vehicle);
                                            //MenuConsole.menu_main_1_label("Matricula: "); String label_matricula= Utils.input(false);
                                            String label_matricula;
                                            boolean plate_exists;
                                            do {
                                                MenuConsole.menu_main_1_label("Matrícula: ");
                                                label_matricula = Utils.input(false);
                                                plate_exists = false;
                                                for (org.JavaCar.Vehicle v : storage) {
                                                    if (v.getMatricula().equals(label_matricula)) {
                                                        plate_exists = true;
                                                        MenuConsole.menu_typo_I("Aquesta matrícula ja està registrada!");
                                                        Utils.b();
                                                        break;
                                                    }
                                                }
                                            } while (plate_exists);
                                            //
                                            MenuConsole.menu_main_1_label("Marca: "); String label_marca= Utils.input(false);
                                            MenuConsole.menu_main_1_label("Model: "); String label_model= Utils.input(false);
                                            double label_preu= Utils.input_datatype_double("Preu base: ");

                                            MenuConsole.menu_main_1_label("Tipus de motor: "); String label_motor_tipus= Utils.input(false);
                                            int label_motor_potencia= Utils.input_datatype_int("Potència: ");
                                            org.JavaCar.Motor label_motor= new org.JavaCar.Motor(label_motor_tipus,label_motor_potencia);

                                            MenuConsole.menu_main_1_label("Marca de la roda: "); String label_roda_marca= Utils.input(false);
                                            double label_roda_diametre= Utils.input_datatype_double("Diàmetre de la roda: ");
                                            org.JavaCar.Roda label_roda= new org.JavaCar.Roda(label_roda_marca,label_roda_diametre);

                                            int label_year= Utils.input_datatype_int("Any de fabricació: ");

                                            switch(input_main_1){
                                                case"1":
                                                    int label_places= Utils.input_datatype_int("Nombre de places: ");
                                                    org.JavaCar.Roda[] label_roda_cotxe= {label_roda,label_roda,label_roda,label_roda};
                                                    org.JavaCar.Cotxe cotxe= new org.JavaCar.Cotxe(label_matricula,label_marca,label_model,label_preu,   label_places   ,label_motor,label_roda_cotxe);
                                                    cotxe.setTypesetYear("cotxe",label_year);
                                                    cotxe.setTheLabel();
                                                    storage.add(cotxe);
                                                    success= true;
                                                break;
                                                case"2":
                                                    int label_cilindrada= Utils.input_datatype_int("Cilindrada: ");
                                                    org.JavaCar.Roda[] label_roda_moto= {label_roda,label_roda};
                                                    org.JavaCar.Moto moto= new org.JavaCar.Moto(label_matricula,label_marca,label_model,label_preu,   label_cilindrada   ,label_motor,label_roda_moto);
                                                    moto.setTypesetYear("moto",label_year);
                                                    moto.setTheLabel();
                                                    storage.add(moto);
                                                    success= true;
                                                break;
                                                case"3":
                                                    double label_carga= Utils.input_datatype_double("Capacitat de carga: ");
                                                    org.JavaCar.Roda[] label_roda_furgoneta= {label_roda,label_roda,label_roda,label_roda};
                                                    org.JavaCar.Furgoneta furgoneta= new org.JavaCar.Furgoneta(label_matricula,label_marca,label_model,label_preu,   label_carga   ,label_motor,label_roda_furgoneta);
                                                    furgoneta.setTypesetYear("furgoneta",label_year);
                                                    furgoneta.setTheLabel();
                                                    storage.add(furgoneta);
                                                    success= true;
                                                break;
                                            }
                                        }
                                        else{
                                            MenuConsole.menu_typo_II(input_main,"[4]");
                                            success= false;
                                        }
                                    }while( !input_main_1.matches("[1-4]") );
                                break;
                                case"2":
                                    MenuConsole.menu_H1();
                                    Utils.text("Llista de vehicles llogats:",255,170,0,true);
                                    Utils.b();
                                    list_display(storage,"No hi ha cap vehicle registrat");
                                    Utils.b();
                                    Utils.text("Escriu qualsevol cosa per tornar al menú",255,255,255,true);
                                    Utils.input(true);
                                    success= false;
                                break;
                                case"3":
                                    MenuConsole.menu_H1();
                                    Utils.text("Llista de vehicles llogats per filtre de preu:",255,170,0,true);
                                    Utils.b();
                                    if( storage.size()==0 ){ Utils.text("No hi ha vehicles per filtrar!",255,85,0,true); }
                                    else{
                                        double price= Utils.input_datatype_double("Escriu un preu màxim per retornar els menors o iguals: ");
                                        List<org.JavaCar.Vehicle> storage_filter= org.JavaCar.GestorLloguers.filtrarPerPreu(storage,price);
                                        if( storage_filter.size()==0 ){ Utils.text("No hi ha vehicles amb aquest filtre",255,255,170,true); }
                                        else{
                                            Utils.text("Els vehicles amb el preu menor o igual a " + price + " són: ", 255, 170, 85, true);
                                            list_display(storage_filter,"No hi ha coincidència");
                                        }
                                    }
                                    Utils.b();
                                    Utils.text("Escriu qualsevol cosa per retornar al menú",255,255,255,true);
                                    Utils.input(true);
                                    success= false;
                                break;
                                case"4":
                                    MenuConsole.menu_H1();
                                    Utils.text("Selecciona un vehicle per retirar:",255,170,0,true);
                                    Utils.b();
                                    list_display(storage,"No hi ha cap vehicle registrat");
                                    Utils.b();
                                    if( storage.size()==0 ){
                                        Utils.text("Escriu qualsevol cosa per retornar al menú",255,255,255,true);
                                        Utils.input(true);
                                        success= false;
                                    }
                                    else{
                                        int storage_id;
                                        boolean loop;
                                        do{
                                            storage_id= Utils.input_datatype_int("Introdueix l'ID del vehicle o escriu '0' per sortir: ")-1;
                                            loop= !(-1<=storage_id && storage_id<storage.size());
                                            if(loop){ Utils.text("ID del vehicle invàlid",255,85,0,true); }
                                        }while( loop );
                                        if( storage_id!=-1 ){
                                            storage.remove(storage_id);
                                            success= true;
                                        }else{ success= false; }
                                    }
                                break;
                                case"5":
                                    MenuConsole.menu_H1();
                                    Utils.text("Ingressos totals:",255,170,0,true);
                                    Utils.b();
                                    if( storage.size()==0 ){
                                        Utils.text("No hi ha vehicles per calcular!",255,85,0,true);
                                    }
                                    else{
                                        int day= Utils.input_datatype_int("Escriu el nombre de dies per calcular: ");
                                        Utils.text("Ingressos per "+day+" dies són: "+"\033[38;2;255;255;0m"+org.JavaCar.GestorLloguers.calcularIngressosTotals(storage,day),255,170,85,true);
                                    }
                                    Utils.b();
                                    Utils.text("Escriu qualsevol cosa per retornar al menú",255,255,255,true);
                                    Utils.input(true);
                                    success= false;
                                break;
                                case"6":break;
                            }
                            MenuConsole.menu_typo_II(input_main,"[1-6]");

                        }while( !input_main.equals("6") );
                        auto_shutdown= true;

                    }else{ auto_shutdown= true; }
                    break;
                case"2": break;
            }
            MenuConsole.menu_typo_II(input_signin,"[1-2]");
            if( auto_shutdown ){ input_signin= "2"; }
        }while( !input_signin.equals("2") );
        MenuConsole.shutdown();
    }

}
