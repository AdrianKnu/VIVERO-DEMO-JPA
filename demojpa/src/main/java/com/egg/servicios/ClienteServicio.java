package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Cliente;
import com.egg.persistencia.ClienteDAO;

public class ClienteServicio {
    private final ClienteDAO daoCliente;// Instancio a la unidad d persistencia para acceder a los metodos del EM

    public ClienteServicio() {
        this.daoCliente = new ClienteDAO();
    }

    public void crearCliente(int codigoCliente, String nombreCliente, String nombreContacto, String apellidoContacto,
            String telefono, String fax, String ciudad, String region, String pais,
            String codigoPostal, int idEmpleado, double limiteCredito) {
        try {

            Cliente clienteNuevo = new Cliente();

            clienteNuevo.setApellidoContacto(apellidoContacto);
            clienteNuevo.setCiudad(ciudad);          
            clienteNuevo.setCodigoCliente(codigoCliente);
            clienteNuevo.setCodigoPostal(codigoPostal);
            clienteNuevo.setFax(fax);
            clienteNuevo.setIdEmpleado(idEmpleado);
            clienteNuevo.setLimite_credito(limiteCredito);
            clienteNuevo.setNombreCliente(nombreCliente);
            clienteNuevo.setNombreContacto(nombreContacto);
            clienteNuevo.setPais(pais);
            clienteNuevo.setRegion(region);
            clienteNuevo.setTelefono(telefono);
                                       
            daoCliente.guardarCliente(clienteNuevo);
        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo el cliente  de manera correcta");
        }

    }

    // MÃ©todo para buscar un cliente por su cÃ³digo (FIND)
    public Cliente buscarCliente(int idCliente) {
        Cliente cliente = daoCliente.buscarCliente(idCliente);
        try {
            if (cliente == null) {
                System.out.println("No existe un cliente con el ID proporcionado: " + idCliente);
            }

            return cliente;

        } catch (

        Exception e) {
            System.out.println("OcurriÃ³ un error al buscar el cliente: " + e.getMessage());
        }
        return null;
    }

    public void listarClientesXNombre(String nombreRecibido) throws Exception {
        List<Cliente> clientesNombre = daoCliente.listarClientesPorNombre(nombreRecibido);
        imprimirLista(clientesNombre);
    }

    public void listarClientesXCiudad(String ciudadRecibida) throws Exception {
        List<Cliente> clientesCiudad = daoCliente.listarClientesPorCiudad(ciudadRecibida);
        imprimirLista(clientesCiudad);
    }

    // Imprimo solo lgunos datos de la BBDD
    public void imprimirLista(List<Cliente> listaRecibida) {
        for (Cliente unitarioCliente : listaRecibida) {
            System.out.println(unitarioCliente.getIdCliente() + "-" + unitarioCliente.getApellidoContacto() + "-"
                    + unitarioCliente.getNombreContacto() + "-" + unitarioCliente.getCiudad());
        }


    }

}
