package com.udistrital.parcial2.decorator;

import com.udistrital.parcial2.config.ConfiguracionSistema;
import com.udistrital.parcial2.modelo.Reporte;

public class MarcaAguaDecorador extends ReporteDecorador {
    
    private String marcaAgua; //Puede estar en final o no
    //private final String marcaAgua;
    
    public MarcaAguaDecorador(Reporte reporte, String marcaAgua) {
        super(reporte);
        this.marcaAgua = marcaAgua;
    }

    @Override
    public String generarContenido() {
        ConfiguracionSistema configuracion = ConfiguracionSistema.getInstancia();

        if (!configuracion.isMostrarMarcaAgua()) {
            return super.generarContenido();
        }

        return super.generarContenido() + "\nMarca de agua: " + marcaAgua;
    }
}
