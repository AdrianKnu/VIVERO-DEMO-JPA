package com.egg.persistencia;

import java.util.List;

import com.egg.entidades.Empleado;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class EmpleadoDAO {

    private final EntityManagerFactory emf = Persistence.createEntityManagerFactory("ViveroPU");
    private final EntityManager em = emf.createEntityManager();

    public void eliminarEmpleado(int idEmpleado) throws Exception {
        Empleado empleado = buscarEmpleado(idEmpleado);
        em.getTransaction().begin();
        em.remove(empleado);
        em.getTransaction().commit();
    }

    public Empleado buscarEmpleado(int idEmpleado) {
        return em.find(Empleado.class, idEmpleado);
    }

    public void listarEmpleadosPorIdOficina(String idOficina) throws Exception {
        em.createQuery("SELECT e FROM Empleado e WHERE e.oficina.idOficina = :idOficina", Empleado.class)
                .setParameter("idOficina", idOficina)
                .getResultList()
                .forEach(System.out::println);
    }
    public List<Empleado> listarEmpleadosExcluyendo(int idEmpleado) throws Exception {
        return em.createQuery(
                "SELECT e FROM Empleado e " +
                "JOIN e.Oficina o " +
                "WHERE e.idEmpleado <> :idEmpleado", Empleado.class)
                .setParameter("idEmpleado", idEmpleado)
                .getResultList();
    }
    public void listarEmpleados() throws Exception {
        em.createQuery("SELECT e FROM Empleado e", Empleado.class)
                .getResultList()
                .forEach(System.out::println);
    }
}
