package com.egg.servicios;

import java.util.List;

import com.egg.entidades.Oficina;
import com.egg.persistencia.OficinaDAO;

public class OficinaServicio {
    private final OficinaDAO daoOficina;// Instancio a la unidad d persistencia para acceder a los métodos del EM

    public OficinaServicio() {
        this.daoOficina = new OficinaDAO();
    }

    public void crearOficna(String codigodOficina, String ciudad, String pais,
            String region, String telefono, String codigoPostal) {

        try {
            // Crear una nueva instancia de Oficina
            Oficina oficinaNueva = new Oficina();

            oficinaNueva.setCiudad(ciudad);
            oficinaNueva.setCodigoPostal(codigoPostal);
            oficinaNueva.setCodigodOficina(codigodOficina);
            oficinaNueva.setPais(pais);
            oficinaNueva.setRegion(region);
            oficinaNueva.setTelefono(telefono);

            // Llamar al método de **OficinaDAO** para persistir la nueva oficina.
            // Puedes agregar validaciones de los datos antes de realizar la persistencia
            // para asegurar que la información sea correcta y consistente
            daoOficina.guardaOficina(oficinaNueva);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo la nueva oficina de manera correcta");
        }

    }
    public void listarOficinas()throws Exception{
        List<Oficina> todasOficinas = daoOficina.listarTodas();
        imprimirLista(todasOficinas);
    }


    public void imprimirLista(List <Oficina> listaRecibida)throws Exception{
        for (Oficina unitariaOficina : listaRecibida){
            System.out.println(unitariaOficina.getCodigodOficina() + " - " + unitariaOficina.getCiudad() + " - " + unitariaOficina.getPais() );
        }
    }

}
