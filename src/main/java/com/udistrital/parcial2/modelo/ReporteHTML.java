package com.udistrital.parcial2.modelo;

public class ReporteHTML implements Reporte {
    @Override
    public String generarContenido() {
        return "Generando contenido del reporte en formato HTML";
    }
}
