package org.example.m1.week2.day5;

import java.util.List;

public abstract class BaseLibreria {
    private long codISBN;
    private String titolo;
    private int annoPublicazione;
    private int numPagine;

    public BaseLibreria(long codISBN, String titolo, int annoPublicazione, int numPagine) {
        this.codISBN = codISBN;
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numPagine = numPagine;
    }

    public BaseLibreria(String titolo, int annoPublicazione, int numPagine) {
        this.titolo = titolo;
        this.annoPublicazione = annoPublicazione;
        this.numPagine = numPagine;
    }

    @Override
    public String toString() {
        return "{" +
                "codISBN=" + codISBN +
                ", titolo='" + titolo + '\'' +
                ", annoPublicazione=" + annoPublicazione +
                ", numPagine=" + numPagine +
                '}';
    }

    public long getCodISBN() {
        return codISBN;
    }

    public String getTitolo() {
        return titolo;
    }

    public int getAnnoPublicazione() {
        return annoPublicazione;
    }

    public int getNumPagine() {
        return numPagine;
    }


}
