package system;
import java.util.Scanner;
import java.io.IOException;

public class Utils {

    private Utils(){ throw new UnsupportedOperationException("Gear is a static class"); }

    private static Scanner scan= new Scanner(System.in);

    public static void clear() {
        //try { new ProcessBuilder("clear").inheritIO().start().waitFor(); }
        //catch (IOException | InterruptedException e) { System.out.print("\033[H\033[2J"); System.out.flush(); }
    }

    public static void text( String input,int r,int g,int b, boolean ln ){
        String text = input.replaceAll("\033\\[[0-9;]*m", "");
        int padding = (width_window() - text.length()) / 2;
        if( padding>0 ){ for( int i=0;i<padding;i++ ){ System.out.print(" "); }}
        String output= "\033[38;2;"+r+";"+g+";"+b+"m"+input+"\033[0m";
        if( ln ){ System.out.println(output); }
        else{ System.out.print(output); }
    }
    public static int width_window() {
        int width = 80;
        try {
            String os = System.getProperty("os.name").toLowerCase();
            if (os.contains("nix") || os.contains("nux") || os.contains("mac")) {
                ProcessBuilder pb = new ProcessBuilder("sh", "-c", "tput cols 2> /dev/tty");
                Process p = pb.start();
                p.waitFor();
                java.io.InputStream stream = p.getInputStream();
                java.util.Scanner scanner = new java.util.Scanner(stream);
                if (scanner.hasNextInt()) { width = scanner.nextInt(); }
                scanner.close();
            }
        }catch(Exception e){}
        return width;
    }
    public static void br(){ for( int i=1;i<=3;i++ ){ text("",0,0,0,true); clear(); }}
    public static void b(){ text("",0,0,0,true); }

    public static String input(boolean auto){
        if( auto==true ){ text("",255,255,255,false); }
        return scan.nextLine().toLowerCase().trim();
    }
    public static String screw_input_datatype(String label, String regex){
        String output;
        boolean loop;
        do{
            MenuConsole.menu_main_1_label(label);
            output= scan.nextLine().trim();
            loop= !output.matches(regex);
            if(loop){ MenuConsole.menu_typo_I("Introdueix el valor correcte!"); }
        }while( loop );
        return output;
    }
    public static int input_datatype_int(String label){ return Integer.parseInt(screw_input_datatype(label,"[0-9]+")); }
    public static double input_datatype_double(String label){ return Double.parseDouble(screw_input_datatype(label,"[0-9]+(\\.[0-9]+)?")); }

    public static void fx_error(){ java.awt.Toolkit.getDefaultToolkit().beep(); }

    public static boolean signin(){
        b();
        MenuConsole.menu_h1();
        b();
        Utils.text("Procés d'inici de sessió:",255,170,0,true);
        b();
        text("Nom d'usuari: ",170,255,170,false);
        String output_user= input(false);
        text("Contrasenya: ",170,255,170,false);
        String output_password= input(false);
        b();

        String[] users= {"ray","kevin","roger"};
        String[] passwords= {"123","456","789"};
        for( int i=0;i<users.length;i++ ){   if( output_user.equals(users[i]) && output_password.equals(passwords[i]) ){ return true; }   }
        return false;
    }

}