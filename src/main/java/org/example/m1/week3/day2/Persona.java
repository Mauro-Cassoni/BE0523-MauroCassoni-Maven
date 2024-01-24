package org.example.m1.week3.day2;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "persona")

public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_di_nascita;
    @Enumerated(EnumType.STRING)
    private Sesso sesso;
    @OneToMany(mappedBy = "persona")
    //@OrderBy("")
    private List<Partecipazione> lista_partecipazioni;

    public Persona(String nome, String cognome, String email, LocalDate data_di_nascita, Sesso sesso) {
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
        this.data_di_nascita = data_di_nascita;
        this.sesso = sesso;
    }

    public List<Partecipazione> getLista_partecipazioni() {
        return lista_partecipazioni;
    }

    public void setLista_partecipazioni(List<Partecipazione> lista_partecipazioni) {
        this.lista_partecipazioni = lista_partecipazioni;
    }

    public Persona() {
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getData_di_nascita() {
        return data_di_nascita;
    }

    public Sesso getSesso() {
        return sesso;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setData_di_nascita(LocalDate data_di_nascita) {
        this.data_di_nascita = data_di_nascita;
    }

    public void setSesso(Sesso sesso) {
        this.sesso = sesso;
    }


    @Override
    public String toString() {
        return "Persona{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", cognome='" + cognome + '\'' +
                ", email='" + email + '\'' +
                ", data_di_nascita=" + data_di_nascita +
                ", sesso=" + sesso +
                '}';
    }
}


