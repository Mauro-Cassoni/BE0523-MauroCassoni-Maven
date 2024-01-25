package org.example.m1.week3.day4;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import org.example.m1.week3.day2.Evento;
import org.example.m1.week3.day2.Persona;

import java.util.Set;

@Entity
@Table(name = "gara_di_atletica")

public class GaraDiAtletica extends Evento {

    private Set<Persona> atleti;
    private Persona vincitore;

    public GaraDiAtletica() {
    }

    public GaraDiAtletica(Set<Persona> atleti, Persona vincitore) {
        this.atleti = atleti;
        this.vincitore = vincitore;
    }

    public Set<Persona> getAtleti() {
        return atleti;
    }

    public void setAtleti(Set<Persona> atleti) {
        this.atleti = atleti;
    }

    public Persona getVincitore() {
        return vincitore;
    }

    public void setVincitore(Persona vincitore) {
        this.vincitore = vincitore;
    }

    @Override
    public String toString() {
        return super.toString() +
                "atleti=" + atleti +
                ", vincitore=" + vincitore;
    }
}
