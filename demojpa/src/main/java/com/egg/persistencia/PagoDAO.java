package com.egg.persistencia;

import java.sql.Date;
import java.util.List;

import com.egg.entidades.Pago;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PagoDAO {
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarPago(Pago pago) throws Exception {
        em.getTransaction().begin();
        em.persist(pago);
        em.getTransaction().commit();
    }
    public Pago buscarPago(int idPago) {
        return em.find(Pago.class, idPago);
    }
    public void eliminarPago(int id) throws Exception {
        Pago pago = buscarPago(id);
        em.getTransaction().begin();
        em.remove(pago);
        em.getTransaction().commit();
    }
    public List<Pago> listarPagosPorFecha(Date fecha) throws Exception {
        return em.createQuery("SELECT p FROM Pago p WHERE p.fecha = :fecha ORDER BY p.fecha DESC", Pago.class)
                .setParameter("fecha", fecha)
                .getResultList();
    }

    //Lista todos los pagos realizados dentro de un rango de fechas recibido como parámetro, junto a la información del cliente (al menos 3 atributos).
    public List<Pago> listarPagosPorRangoDeFechasYCliente(Date fechaInicio, Date fechaFin, String nombreCliente, int idCliente, int codigoCliente) throws Exception {
        return em.createQuery("SELECT p FROM Pago p WHERE p.fecha BETWEEN :fechaInicio AND :fechaFin ORDER BY p.fecha DESC", Pago.class)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();
    }
}
