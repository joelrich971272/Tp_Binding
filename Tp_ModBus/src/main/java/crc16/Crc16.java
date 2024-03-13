package crc16;

import outils.In;


public class Crc16 {
    public static int stdPoly = 0xA001;
    public static int initialValue = 0xffff;

    public static void main(String[] args) {
        System.out.println("Saisir la chaine d'octets en hexa ");
        String trame = In.readString() ;


    }


    static int calculCrc16(byte[] octets,int ValeurInitiale,int polynomme){
        octets = new byte[8];
        return polynomme ;
    }
    static byte[] hexaStringEnBytearray (String message) {
        int len = message.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i+=2) {
            data[i/2] = (byte) ((Character.digit(message.charAt(i),16) << 4)+
            Character.digit(message.charAt(i+1),16));

        }


return data;    }
    static byte[] formatage (String trame) {
        byte[] a = new byte[1];
        if (trame.length() % 2 == 0) {
            System.out.println(trame.length() % 2);
            return hexaStringEnBytearray(trame);
        } else {

        }
        return a;
    }
}
