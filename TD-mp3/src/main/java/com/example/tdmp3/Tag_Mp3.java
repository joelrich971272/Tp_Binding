package com.example.tdmp3;

import java.nio.file.Path;

public class Tag_Mp3 {
    private Tag_Mp3 tag;
    String titre;
    String artiste;
    String album;
    byte genre;
    String commentaire;
    byte track;
    String annee;

    public Tag_Mp3 getTag() {
        return tag;
    }

    public void setTag(Tag_Mp3 tag) {
        this.tag = tag;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getArtiste() {
        return artiste;
    }

    public void setArtiste(String artiste) {
        this.artiste = artiste;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public byte getGenre() {
        return genre;
    }

    public void setGenre(byte genre) {
        this.genre = genre;
    }

    public String getCommentaire() {
        return commentaire;
    }

    public void setCommentaire(String commentaire) {
        this.commentaire = commentaire;
    }

    public byte getTrack() {
        return track;
    }

    public void setTrack(byte track) {
        this.track = track;
    }

    public String getAnnee() {
        return annee;
    }

    public void setAnnee(String annee) {
        this.annee = annee;
    }


}
