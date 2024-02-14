import jssc.SerialPortEvent;
import jssc.SerialPortException;

import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Application extends LiaisonSerie {
//    public Application() {
//        super.listerLesPorts().forEach((com)-> System.out.println(com));
//
//    }

    public void serialEvent(SerialPortEvent spe){
        super.serialEvent(spe);

    }
    public void deconnexionCapteur(){
        super.fermerPort();

    }
    public void ecrire(byte[] b){
        super.ecrire(b);

    }
    public void initialisation(String s) throws SerialPortException, InterruptedException {
        while (true){
            super.initCom(s);
            super.configurerParametres(9600,8,0,2);

        }

    }



}
