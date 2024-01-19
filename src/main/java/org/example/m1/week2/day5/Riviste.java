package org.example.m1.week2.day5;

import java.util.List;
import java.util.Random;

public class Riviste extends BaseLibreria{

    private Periodicita periodicita;

    public Riviste(long codISBN, String titolo, int annoPublicazione, int numPagine, Periodicita periodicita) {
        super(codISBN, titolo, annoPublicazione, numPagine);
        this.periodicita=periodicita;
    }

    public Riviste(String titolo, int annoPublicazione, int numPagine, Periodicita periodicita) {
        super(titolo, annoPublicazione, numPagine);
        this.periodicita=periodicita;
    }

    public Periodicita getPeriodicita() {
        return periodicita;
    }

    public void setPeriodicita(Periodicita periodicita) {
        this.periodicita = periodicita;
    }

    @Override
    public String toString() {
        return super.toString() +
                "{" +
                "periodicita=" + periodicita +
                '}';
    }


}
