package com.egg.persistencia;

import java.util.List;

import com.egg.entidades.Oficina;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class OficinaDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardaOficina(Oficina oficina) throws Exception {
        em.getTransaction().begin();
        em.persist(oficina);
        em.getTransaction().commit();
    }

    public  List <Oficina> listarTodas()throws Exception{
        return em.createQuery("SELECT o FROM Oficina o", Oficina.class)
        .getResultList() ;
       }  
}
