package com.udistrital.parcial2.modelo;

public class ReporteExcel implements Reporte {
    @Override
    public String generarContenido() {
        return "Generando contenido del reporte en un Excel";
    }
}
