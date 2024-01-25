package org.example.m1.week3.day4;

import jakarta.persistence.*;
import org.example.m1.week3.day2.Evento;


@Entity
@Table(name = "concerto")
public class Concerto extends Evento {

    @Enumerated(EnumType.STRING)
    private Genere genere;

    @Column(name = "in_streaming")
    private Boolean inStreaming;

    public Concerto() {
    }

    public Concerto(Genere genere, Boolean inStreaming) {
        this.genere = genere;
        this.inStreaming = inStreaming;
    }

    public Genere getGenere() {
        return genere;
    }

    public void setGenere(Genere genere) {
        this.genere = genere;
    }

    public Boolean getInStreaming() {
        return inStreaming;
    }

    public void setInStreaming(Boolean inStreaming) {
        this.inStreaming = inStreaming;
    }

    @Override
    public String toString() {
        return super.toString() +
                "genere=" + genere +
                ", inStreaming=" + inStreaming;
    }
}
