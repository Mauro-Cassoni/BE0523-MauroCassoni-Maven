package org.example.m1.week3.day2;


import org.example.DAO.EventoDAO;
import org.example.DAO.LocationDAO;
import org.example.DAO.PartecipazioneDAO;
import org.example.DAO.PersonaDAO;
import org.example.m1.week3.day4.PartitaDiCalcio;

import javax.management.Query;
import java.time.LocalDate;
import java.util.List;

public class UsaEvento {

    public static void main(String[] args) {

        EventoDAO eventoDao = new EventoDAO();
        LocationDAO locationDao = new LocationDAO();
        PartecipazioneDAO partecipazioneDao = new PartecipazioneDAO();
        PersonaDAO personaDao = new PersonaDAO();
//
//        Persona persona1 = new Persona();
//        persona1.setNome("Mario");
//        persona1.setCognome("Rossi");
//
//        Persona persona2 = new Persona();
//        persona2.setNome("Luigi");
//        persona2.setCognome("Verdi");
//
//            personaDao.save(persona1);
//            personaDao.save(persona2);
//
//        Location location1 = new Location();
//        location1.setCitta("Milano");
//
//            locationDao.save(location1);
//
//
//        Evento evento1 = new Evento();
//        evento1.setDescrizione("descrizione");
//        evento1.setLocation(location1);
//
//        Evento evento2 = new Evento();
//        evento2.setDescrizione("descrizione 2");
//        evento2.setLocation(location1);
//
//            eventoDao.save(evento1);
//            eventoDao.save(evento2);
//
//        Partecipazione partecipazione1 = new Partecipazione();
//        partecipazione1.setPersona(persona1);
//        partecipazione1.setEvento(evento1);
//
//        Partecipazione partecipazione2 = new Partecipazione();
//        partecipazione2.setPersona(persona1);
//        partecipazione2.setEvento(evento2);
//
//        Partecipazione partecipazione3 = new Partecipazione();
//        partecipazione3.setPersona(persona2);
//        partecipazione3.setEvento(evento2);
//
//        partecipazioneDao.save(partecipazione1);
//        partecipazioneDao.save(partecipazione2);
//        partecipazioneDao.save(partecipazione3);

        PartitaDiCalcio partita1 = new PartitaDiCalcio();
        partita1.setDescrizione("A vs B");
        partita1.setSquadraCasa("A");
        partita1.setSquadraOspite("B");
        partita1.setGolSquadraCasa(3);
        partita1.setGolSquadraOspite(1);
        partita1.getSquadraVincente();









    }




}
