package org.example.m1.week3.day2;


import org.example.DAO.EventoDAO;
import org.example.DAO.LocationDAO;
import org.example.DAO.PartecipazioneDAO;
import org.example.DAO.PersonaDAO;

import java.time.LocalDate;
import java.util.List;

public class UsaEvento {

    public static void main(String[] args) {

        EventoDAO eventoDao = new EventoDAO();
        LocationDAO locationDao = new LocationDAO();
        PartecipazioneDAO partecipazioneDao = new PartecipazioneDAO();
        PersonaDAO personaDao = new PersonaDAO();

        Location location = new Location("Parco","Roma");
        Persona persona = new Persona("Mario","Rossi","mario@rossi.it",LocalDate.of(1994,10,01),Sesso.M);
        Evento evento = new Evento("Evento 1",LocalDate.of(2024,01,10),"Descrizione evento 1",TipoEvento.RIUNIONE,25,location);
        Partecipazione partecipazione = new Partecipazione(persona,evento,Stato.CONFERMATA);

        locationDao.save(location);
        personaDao.save(persona);
        eventoDao.save(evento);
        partecipazioneDao.save(partecipazione);



    }




}
