package org.example.DAO;

import org.example.m1.week3.day2.Location;
import org.example.m1.week3.day2.Persona;

import jakarta.persistence.*;


public class LocationDAO {

    private EntityManagerFactory emf;
    private EntityManager em;

    public LocationDAO() {
        emf = Persistence.createEntityManagerFactory("gestioneeventi");
        em = emf.createEntityManager();
    }

    public void save(Location l){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.persist(l);

        et.commit();

        em.refresh(l);
    }

    public Location getById(int id){

        return em.find(Location.class, id);

    }

    public void delete(int id){
        EntityTransaction et = em.getTransaction();

        et.begin();

        em.remove( getById(id) );

        et.commit();

    }


}
