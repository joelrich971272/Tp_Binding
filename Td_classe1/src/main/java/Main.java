import clavier.In;
import jssc.SerialPortException;

import java.nio.charset.Charset;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws SerialPortException, InterruptedException {
        Application ap = new Application() ;
        ap.listerLesPorts().forEach(com-> System.out.println(com));
        ap.initialisation("com10");
        while (true){
            System.out.println("commande svp");
            ap.ecrire(In.readString().getBytes(Charset.defaultCharset()));
        }


    }
}
