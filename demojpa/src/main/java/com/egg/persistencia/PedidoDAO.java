package com.egg.persistencia;

import java.sql.Date;
import java.util.List;

import com.egg.entidades.Pedido;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PedidoDAO {
    
    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void guardarPedido(Pedido pedido) throws Exception {
        em.getTransaction().begin();
        em.persist(pedido);
        em.getTransaction().commit();
    }

    public Pedido buscarPedido(int idPedido) {
        return em.find(Pedido.class, idPedido);
    }

    public void eliminarPedido(int id) throws Exception {
        Pedido pedido = buscarPedido(id);
        em.getTransaction().begin();
        em.remove(pedido);
        em.getTransaction().commit();
    }

    public List<Pedido> listarPedidosPorFecha(Date fecha) throws Exception {
        return em.createQuery("SELECT p FROM Pedido p WHERE p.fecha = :fecha ORDER BY p.fecha DESC", Pedido.class)
                .setParameter("fecha", fecha)
                .getResultList();
    }

    public List<Pedido> listarPedidosPorClientePorRangoDeFechas(int idCliente, Date fechaInicio, Date fechaFin) throws Exception {
        return em.createQuery("SELECT p FROM Pedido p WHERE p.cliente.id = :idCliente AND p.fecha BETWEEN :fechaInicio AND :fechaFin ORDER BY p.fecha DESC", Pedido.class)
                .setParameter("idCliente", idCliente)
                .setParameter("fechaInicio", fechaInicio)
                .setParameter("fechaFin", fechaFin)
                .getResultList();
    }
    
}
