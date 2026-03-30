package system;

public class MenuConsole {

   private MenuConsole(){ throw new UnsupportedOperationException("Display is a static class"); }


   private static String c1= "\033[48;2;102;102;102m";
   private static String c3= "\033[48;2;151;151;151m";
   //y para texto es "\033[38;2;255;170;0m"
   private static String cA= "\033[38;2;102;102;102m";
   private static String cB= "\033[38;2;151;151;151m";
   private static String cD= "\033[38;2;255;255;255m";
   private static String cc= "\033[0m";
   public static void logo(){
      Utils.text("     "+c1+" "+cD+"▄▄▄▄▄  ▄▄▄▄▄ "+cc+cA+"     ",102,102,102,true);
      Utils.text("     "+c1+" "+c3+"     "+c1+"  "+c3+"     "+c1+" "+cc+cA+""+"    "+cc+" ",102,102,102,true);
      Utils.text(" "+c1+"     "+cB+"▀▀▀▀▀  ▀▀▀▀▀     "+cc+cA+" ",102,102,102,true);
      Utils.text(" "+c1+"    "+c3+cA+"▀▀▀"+c1+"        "+c3+cA+"▀▀▀"+c1+"    "+cc+" ",102,102,102,true);
      Utils.text("       "+c3+cA+" ▀ "+cc+"        "+c3+cA+" ▀ "+cc+"       ",102,102,102,true);
   }

   public static void menu_h1(){
      logo();
      Utils.b();
      Utils.text("J Λ V Λ C Λ R",255,170,0,true);
   }
   public static void menu_H1(){
      Utils.br();Utils.clear();
      Utils.b();
      menu_h1();
      Utils.b();
   }
   public static void menu_option(String n,String m){
      Utils.text(""+n+"\033[38;2;255;255;255m"+m,0,255,0,true);
   }

   public static void menu_signin(){
      Utils.b();
      menu_h1();
      Utils.b();
      menu_option("1",". Iniciar Sessió");
      menu_option("2",". Sortir");
      Utils.b();
   }

   public static void menu_main(){
      Utils.b();
      menu_h1();
      Utils.b();
      menu_option("1",". Registrar lloguer");
      menu_option("2",". Mostrar vehicles llogats");
      menu_option("3",". Mostrar vehicles llogats per filtre");
      menu_option("4",". Retirar lloguer registrat");
      menu_option("5",". Mostrar ingressos totals");
      menu_option("6",". Sortir");
      Utils.b();
   }
   public static void menu_main_1(){
      Utils.b();
      menu_h1();
      Utils.b();
      Utils.text("Registrar lloguer:",255,170,0,true);
      Utils.b();
      menu_option("1",". Cotxe");
      menu_option("2",". Moto");
      menu_option("3",". Furgoneta");
      menu_option("4",". Sortir");
      Utils.b();
   }
   public static void menu_main_1_(String input){
      Utils.b();
      menu_h1();
      Utils.b();
      Utils.text("Registrar lloguer de "+input+":",255,170,0,true);
      Utils.b();
   }
   public static void menu_main_1_label(String input) { Utils.text(input,153,204,102,false); }
   public static void menu_main_success(){
      Utils.text("Canvis fet correctament!",255,255,170,true);
      Utils.b();
   }

   public static void menu_typo_I(String input){
      Utils.text(input,85,85,85,true);
      Utils.fx_error();
   }
   public static void menu_typo_II( String input, String regex ){ if( !input.matches(regex) ){ menu_typo_I("Digitar una opción!"); } }
   public static void shutdown(){
      Utils.text("Apagant el sistema...",255,85,0,true);
      Utils.text("Sistema apagat",255,85,0,true);
   }

}
