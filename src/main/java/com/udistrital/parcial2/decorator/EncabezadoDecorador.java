package com.udistrital.parcial2.decorator;

import com.udistrital.parcial2.modelo.Reporte;

public class EncabezadoDecorador extends ReporteDecorador {
    private String encabezado; //puede estar en final o no
    //private final String encabezado;

    public EncabezadoDecorador(Reporte reporte, String encabezado) {
        super(reporte);
        this.encabezado = encabezado;
    }

    @Override
    public String generarContenido() {
        return "Encabezado: " + encabezado + "\n" + super.generarContenido();
    }
}
