package org.example.m1.week3.day2;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table

public class Location {

    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
        private int id;

    private String nome;
    private String citta;

    @OneToMany(mappedBy = "location")
    private List<Evento> eventi;

    public Location(String nome, String citta) {
        this.nome = nome;
        this.citta = citta;
    }

    public Location() {
    }

    public int getId() {
        return id;
    }

    public List<Evento> getEventi() {
        return eventi;
    }

    public void setEventi(List<Evento> eventi) {
        this.eventi = eventi;
    }

    public String getNome() {
        return nome;
    }

    public String getCitta() {
        return citta;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCitta(String citta) {
        this.citta = citta;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", citta='" + citta + '\'' +
                '}';
    }
}
