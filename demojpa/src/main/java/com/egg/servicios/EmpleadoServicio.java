package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Empleado;
import com.egg.persistencia.EmpleadoDAO;

public class EmpleadoServicio {
    private final EmpleadoDAO daoEmpleado;// Instancio a la unidad d persistencia para acceder a los metodos del EM

    public EmpleadoServicio() {
        this.daoEmpleado = new EmpleadoDAO();
    }

    public void eliminar(int id) {
        try {
            daoEmpleado.eliminarEmpleado(id);
            System.out.println("EMPLEADO ELIMINADO CON EXITO");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("NO SE ENCONTRO EL EMPLEADO PARA ELIMINAR");
        }

    }

    public Empleado buscarEmpleado(int idEmpleado) {
        Empleado empleadoBuscado = daoEmpleado.buscarEmpleado(idEmpleado);
        try {
            if (empleadoBuscado == null) {
                System.out.println("No existe un empleado con el ID proporcionado: " + idEmpleado);
            }
            return empleadoBuscado;

        } catch (

        Exception e) {
            System.out.println("OcurriÃ³ un error al buscar  al empleado: " + e.getMessage());
        }
        return null;
    }

    public void listarEmpleadosPorIdOficina(String idOficina) {
        try {
            daoEmpleado.listarEmpleadosPorIdOficina(idOficina);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al listar los empleados: " + e.getMessage());
        }
    }
    public void imprimirEmpleadoPorIdOficina(String idOficina) {
        try {
            daoEmpleado.listarEmpleadosPorIdOficina(idOficina);
        } catch (Exception e) {
            System.out.println("Ocurrio un error al listar los empleados: " + e.getMessage());
        }
    }
    public void imprimirEmpleadosExcluyendo(int idEmpleado) throws Exception {
        List<Empleado> listaEmpleados = daoEmpleado.listarEmpleadosExcluyendo(idEmpleado);
        for (Empleado empleado : listaEmpleados) {
            System.out.println(empleado.getNombre() + " - " +
                               empleado.getOficina().getCiudad() + " - " +
                               empleado.getOficina().getCodigodOficina());
        }
    }
    public void imprimirEmpleados() {
        try {
            daoEmpleado.listarEmpleados();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al listar los empleados: " + e.getMessage());
        }
    }
}