package com.udistrital.parcial2.decorator;

import com.udistrital.parcial2.modelo.Reporte;

public abstract class ReporteDecorador implements Reporte {
    protected Reporte reporte;

    public ReporteDecorador(Reporte reporte) {
        this.reporte = reporte;
    }

    @Override
    public String generarContenido() {
        return reporte.generarContenido();
    }
}
