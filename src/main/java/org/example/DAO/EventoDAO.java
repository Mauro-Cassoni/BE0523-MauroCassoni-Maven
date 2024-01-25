package org.example.DAO;

import org.example.m1.week3.day2.Evento;
import jakarta.persistence.*;

import org.example.m1.week3.day4.Concerto;
import org.example.m1.week3.day4.PartitaDiCalcio;
import org.hibernate.annotations.NamedQuery;

import javax.management.Query;
import java.util.List;


@NamedQuery(name = "getConcertiInStreaming", query = "select c from Concerto c where c.in_streaming = :in_streaming")
@NamedQuery(name = "getConcertiPerGenere", query = "select c from Concerto c where c.genere = :genere")

@NamedQuery(name = "getPartiteVinteInCasa", query = "select p from PartitaDiCalcio p where p.squadraVincente = :squadraVincente")
@NamedQuery(name = "getPartiteVinteInTrasferta", query = "select p from PartitaDiCalcio p where p.squadraVincente = :squadraVincente")



public class EventoDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public EventoDAO() {

        emf = Persistence.createEntityManagerFactory("eventi");
        em = emf.createEntityManager();
    }

    public void save(Evento e){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(e);

        et.commit();

        em.refresh(e);
    }

    public Evento getById(int id){

        return em.find(Evento.class, id);

    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.remove( getById(id) );

        et.commit();

    }


    public void update(Evento e) {
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.merge(e);

        et.commit();
    }

    public List<Concerto> getConcertiInStreaming(boolean inStreaming) {
        TypedQuery<Concerto> query = em.createNamedQuery("getConcertiInStreaming", Concerto.class);
        query.setParameter("in_streaming", inStreaming);
        return query.getResultList();
    }

    public List<Concerto> getConcertiPerGenere(String genere) {
        TypedQuery<Concerto> query = em.createNamedQuery("getConcertiPerGenere", Concerto.class);
        query.setParameter("genere",genere);
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInCasa() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInCasa", PartitaDiCalcio.class);
        query.setParameter("squadraVincente","squadra_di_casa");
        return query.getResultList();
    }

    public List<PartitaDiCalcio> getPartiteVinteInTrasferta() {
        TypedQuery<PartitaDiCalcio> query = em.createNamedQuery("getPartiteVinteInTrasferta", PartitaDiCalcio.class);
        query.setParameter("squadraVincente","squadra_ospite");
        return query.getResultList();
    }





}
