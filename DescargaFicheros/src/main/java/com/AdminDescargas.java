package com;

import java.util.ArrayList;

public class AdminDescargas {

    ArrayList<Descarga> listaDescargas=new ArrayList<>();

    public void addDescarga(Descarga descarga){
        listaDescargas.add(descarga);
    }

    public void iniciarDescargas(){

        for(Descarga descarga:listaDescargas){
            descarga.start();
        }

        for(Descarga descarga:listaDescargas){
            try {
                descarga.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public void ordenarDescargas(){

        iniciarDescargas();
        listaDescargas.sort(new DescargaComparetor());

        System.out.println("");
        System.out.println("Resumen de las descargas: ");
        System.out.println("");

        for(Descarga descarga:listaDescargas){
            System.out.println("La descarga de "+ descarga.getNombreArchivo()
            +" ha tardado "+ descarga.getTiempoDescarga()+ " ms");
            mostrarMensajeSuperacion(descarga);

        }
    }

    public void mostrarMensajeSuperacion(Descarga descarga){
        if(descarga.getTiempoDescarga()>3000){
            System.out.println("(Tiempo de descarga recomendado excedido)" );
        }
    }
}
