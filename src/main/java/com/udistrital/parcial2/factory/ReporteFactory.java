package com.udistrital.parcial2.factory;

import com.udistrital.parcial2.config.ConfiguracionSistema;
import com.udistrital.parcial2.modelo.Reporte;
import com.udistrital.parcial2.modelo.ReporteExcel;
import com.udistrital.parcial2.modelo.ReporteHTML;
import com.udistrital.parcial2.modelo.ReportePDF;

public class ReporteFactory {
    public Reporte crearReporte(String tipo) {
        String tipoReporte = normalizarTipo(tipo);
        //o ruleSw
        switch (tipoReporte) {
            case "PDF":
                return new ReportePDF();
            case "EXCEL":
                return new ReporteExcel();
            case "HTML":
                return new ReporteHTML();
            default:
                throw new IllegalArgumentException("Tipo de reporte no soportado: " + tipo);
        }
    }

    private String normalizarTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            return ConfiguracionSistema.getInstancia().getFormatoPorDefecto().toUpperCase();
        }
        return tipo.trim().toUpperCase();
    }
}
