package com.egg.servicios;

import com.egg.entidades.GamaProducto;
import com.egg.persistencia.GamaProductoDAO;

public class GamaServicio {
    private final GamaProductoDAO daoGama;// Instancio a la unidad d persistencia para acceder a los métodos del EM

    public GamaServicio() {
        this.daoGama = new GamaProductoDAO();
    }

    public void crearGama(String descripcionTexto, String descripcionHtml, String gama, String imagen) {

        try {
            GamaProducto gamaNueva = new GamaProducto();

            gamaNueva.setDescripcionTexto(descripcionTexto);
            gamaNueva.setDescripcionHtml(descripcionHtml);
            gamaNueva.setGama(gama);
            gamaNueva.setImagen(imagen);

            daoGama.guardaGama(gamaNueva);

        } catch (Exception e) {
            System.out.println(e.toString() + "No se guardo la nueva gamaProducto de manera correcta");
        }

    }


  // MÃ©todo para buscar un cliente por su cÃ³digo (FIND)
    public GamaProducto buscarGamaProducto(int idGama) {
        GamaProducto gama = daoGama.buscarGama(idGama);
        try {
            if (gama == null) {
                System.out.println("No existe una gama con el ID proporcionado: " + idGama);
            }

            return gama;

        } catch (

        Exception e) {
            System.out.println("OcurriÃ³ un error al buscar la gama: " + e.getMessage());
        }
        return null;
    }

    void listarGamas() {
        try {
            daoGama.listarGamas();
        } catch (Exception e) {
            System.out.println("Ocurrio un error al listar las gamas: " + e.getMessage());
        }
    }
}