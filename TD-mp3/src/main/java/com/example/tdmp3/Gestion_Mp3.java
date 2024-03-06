package com.example.tdmp3;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;

public class Gestion_Mp3 {
    private Path fileSource;
    private Tag_Mp3 tag;
    private byte[] tab ;

    public Gestion_Mp3(Path fileSource) {
        this.fileSource = fileSource;
        tab = new byte[128];
        tag = new Tag_Mp3() ;
    }


    public void lireTag() throws IOException {

        InputStream is = Files.newInputStream(fileSource);
        DataInputStream dis = new DataInputStream(is);
        dis.skipBytes((int) (Files.size(fileSource)-128));
        dis.read(tab);
        dis.close();
        System.out.println(new String(tab,3,30));

    }

}
