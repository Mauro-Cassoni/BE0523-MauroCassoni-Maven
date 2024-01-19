package org.example.m1.week2.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Libri extends BaseLibreria {

    private String autore;
    private List<Genere> genere;
    public Libri(long codISBN, String titolo, int annoPublicazione, int numPagine, String autore, Genere ...genere) {
        super(codISBN, titolo, annoPublicazione, numPagine);
        this.autore=autore;
        this.genere=Arrays.asList(genere);
    }

    public Libri(String titolo, int annoPublicazione, int numPagine, String autore, Genere ...genere) {
        super(titolo, annoPublicazione, numPagine);
        this.autore=autore;
        this.genere=Arrays.asList(genere);
    }



    public String getAutore() {
        return autore;
    }

    public List<Genere> getGenere() {
        return genere;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public void setGenere(List<Genere> genere) {
        this.genere = genere;
    }

    @Override
    public String toString() {
        return super.toString() +
                "Libri{" +
                "autore='" + autore + '\'' +
                ", genere=" + genere +
                '}';
    }





}
