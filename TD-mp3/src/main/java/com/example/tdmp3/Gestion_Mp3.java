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
    private void ecrireTags(){
        for (int i = 0; i < tab.length ; i++) {
            tab[i] = (byte)0x00;
        }
        for (int i = 0; i < tab.length ; i++) {
            tab[3+i] = (byte)tag.getTitre().charAt(i);
        }
    }


    public void lireTag() throws IOException {
        tag.getAlbum();
        tag.getArtiste();
        tag.getAnnee();
        tag.getGenre();
        tag.getCommentaire();
        tag.getTitre();
        tag.getTrack();
        tag.getTag();
        InputStream is = Files.newInputStream(fileSource);
        DataInputStream dis = new DataInputStream(is);
        dis.skipBytes((int) (Files.size(fileSource)-128));
        dis.read(tab);
        dis.close();
        tag.setTitre(new String(tab,3,3));
        tag.setAlbum(new String(tab,63,30));
        tag.setAnnee(new String(tab,93,4));
        tag.setArtiste(new String(tab,33,30));
        tag.setCommentaire(new String(tab,97,28));
        tag.setTrack(tab[126]);
        tag.setGenre(tab[127]);

    }

    public Tag_Mp3 getTag() {
        return tag;
    }
}

