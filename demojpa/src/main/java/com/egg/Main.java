package com.egg;

import com.egg.servicios.ClienteServicio;


public class Main {
    public static void main(String[] args) {
        System.out.println("Listado de Oficinas");
        System.out.println("Código - Ciudad - País");
        System.out.println("----------------------------");
        /*//OficinaServicio oficinaServicio = new OficinaServicio();
       // oficinaServicio.crearOficna("OF001", "Buenos Aires", "Argentina", "Capital Federal", "123456789", "1234");
       // oficinaServicio.crearOficna("OF002", "Córdoba", "Argentina", "Córdoba", "987654321", "4321");

         try {
            oficinaServicio.listarOficinas();
        } catch (Exception e) {
            System.out.println("Error al listar las oficinas");
        }*/

        ClienteServicio clienteServicio = new ClienteServicio();
        clienteServicio.crearCliente(1, "Cliente 1", "Contacto 1", "Apellido 1", "123456789", "1234", "Capital Federal", "Buenos Aires", "Argentina", "1234", 1, 1000);
        clienteServicio.crearCliente(2, "Cliente 2", "Contacto 2", "Apellido 2", "987654321", "4321", "Córdoba", "Córdoba", "Argentina", "4321", 2, 2000);
        try {
            clienteServicio.listarClientesXCiudad("Capital Federal");
        } catch (Exception e) {
            System.out.println("Error al listar los clientes");
        }
    }
}