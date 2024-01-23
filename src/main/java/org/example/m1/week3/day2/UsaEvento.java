package org.example.m1.week3.day2;


import org.example.DAO.EventoDAO;

import java.time.LocalDate;

public class UsaEvento {

    public static void main(String[] args) {

        EventoDAO dao = new EventoDAO();

        Evento e = new Evento("Evento 1",LocalDate.of(2024,01,10),"Descrizione evento 1",TipoEvento.RIUNIONE,25);

        dao.save(e);
        System.out.println(dao.getById(1));

        dao.delete(1);

    }




}
