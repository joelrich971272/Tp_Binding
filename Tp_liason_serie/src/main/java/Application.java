import jssc.SerialPortEvent;
import jssc.SerialPortException;

import java.nio.charset.StandardCharsets;

public class Application extends LiaisonSerie {
    public Application() {
    }


    @Override
    public void serialEvent(SerialPortEvent event) {
        //super.serialEvent(event);
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        byte[] laTrame;
        int longeur = 0;
        longeur = event.getEventValue();

        laTrame = lireTrame(longeur);

        for (byte b : laTrame) {
            sb1.append((b&0xff)+" ");
        }

        for (byte b : laTrame) {
            sb2.append(String.format("%02X ", b));
        }
      /*  "%02X " : C'est la chaîne de format. Les spécificateurs de format commencent par % et sont suivis par des caractères qui indiquent le type de format.
                Dans ce cas :
                        %02X : % indique le début d'un spécificateur de format.
                                0 : Indique que le nombre doit être rempli de zéros à gauche.
                                2 : Indique la largeur minimale du champ, ici au moins deux caractères.
                                X : Indique que le nombre doit être formaté en hexadécimal (lettre majuscule).
                                " " : Ajoute un espace à la fin. Cela peut être utilisé pour séparer les représentations hexadécimales de plusieurs octets.*/

        System.out.println("""
                 ______________
                |  Reception   |
                |______________|
                   | bytes       -> %s      
                   | bytes (hex) -> %s          
                   | ASCII       -> %s
                """.formatted(sb1,sb2, new String(laTrame, StandardCharsets.US_ASCII)));
    }

    public void ecrire(byte[] b)  {
        super.ecrire(b);
    }

    public void initialisation(String lePortCom) throws SerialPortException {
        super.initCom(lePortCom);
        super.configurerParametres(9600, 8, 0, 2);
    }

    public void deconnexionCapteur() {
        super.fermerPort();
    }



}
