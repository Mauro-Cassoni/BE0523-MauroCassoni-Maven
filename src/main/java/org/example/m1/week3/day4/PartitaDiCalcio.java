package org.example.m1.week3.day4;

import jakarta.persistence.*;
import org.example.m1.week3.day2.Evento;
import org.example.m1.week3.day2.Location;
import org.example.m1.week3.day2.TipoEvento;

@Entity
@DiscriminatorValue("partita_di_calcio")

public class PartitaDiCalcio extends Evento {

    @Column(name = "squadra_di_casa")
    private String squadraCasa;

    @Column(name = "squadra_ospite")
    private String squadraOspite;

    @Column(name = "squadra_vincente")
    private String squadraVincente;

    @Column(name = "gol_squadra_di_casa")
    private int golSquadraCasa;

    @Column(name = "gol_squadra_ospite")
    private int golSquadraOspite;

    public PartitaDiCalcio() {
    }

    public PartitaDiCalcio(String squadraCasa, String squadraOspite, String squadraVincente, int golSquadraCasa, int golSquadraOspite) {
        this.squadraCasa = squadraCasa;
        this.squadraOspite = squadraOspite;
        this.golSquadraCasa = golSquadraCasa;
        this.golSquadraOspite = golSquadraOspite;
        if (this.golSquadraCasa > this.golSquadraOspite) this.squadraVincente = this.squadraCasa;
        else if (this.golSquadraCasa < this.golSquadraOspite) this.squadraVincente = this.squadraOspite;

    }

    public String getSquadraVincente() {
        return squadraVincente;
    }

    public void setSquadraVincente(String squadraVincente) {
        this.squadraVincente = squadraVincente;
    }

    public String getSquadraCasa() {
        return squadraCasa;
    }

    public void setSquadraCasa(String squadraCasa) {
        this.squadraCasa = squadraCasa;
    }

    public String getSquadraOspite() {
        return squadraOspite;
    }

    public void setSquadraOspite(String squadraOspite) {
        this.squadraOspite = squadraOspite;
    }

    public int getGolSquadraCasa() {
        return golSquadraCasa;
    }

    public void setGolSquadraCasa(int golSquadraCasa) {
        this.golSquadraCasa = golSquadraCasa;
    }

    public int getGolSquadraOspite() {
        return golSquadraOspite;
    }

    public void setGolSquadraOspite(int golSquadraOspite) {
        this.golSquadraOspite = golSquadraOspite;
    }

    @Override
    public String toString() {
        return super.toString() +
                "squadraCasa='" + squadraCasa + '\'' +
                ", squadraOspite='" + squadraOspite + '\'' +
                ", squadraVincente='" + squadraVincente + '\'' +
                ", golSquadraCasa=" + golSquadraCasa +
                ", golSquadraOspite=" + golSquadraOspite;
    }
}
