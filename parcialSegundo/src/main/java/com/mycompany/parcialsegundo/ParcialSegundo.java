package com.mycompany.parcialsegundo;

import apartamentos.AdministradorEdificio;
import java.io.IOException;

public class ParcialSegundo {

    public static void main(String[] args) {
        AdministradorEdificio admin = new AdministradorEdificio();
        try {
            admin.cargarDatosInquilinosDesdeArchivo("./inquilinos.txt");
            admin.generarInformeFinDeMes();
        } catch (IOException e) {
            System.out.println("se ha generado una excepción");
        }
    }
}

