package org.example.DAO;

import org.example.m1.week3.day2.Evento;
import org.example.m1.week3.day2.Persona;

import jakarta.persistence.*;


public class PersonaDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public PersonaDAO() {
        emf = Persistence.createEntityManagerFactory("gestioneeventi");
        em = emf.createEntityManager();
    }

    public void save(Persona p){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(p);

        et.commit();

        em.refresh(p);
    }

    public Persona getById(int id){

        return em.find(Persona.class, id);

    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.remove( getById(id) );

        et.commit();

    }
}
