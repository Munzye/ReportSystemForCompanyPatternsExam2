package com.udistrital.parcial2.decorator;

import com.udistrital.parcial2.config.ConfiguracionSistema;
import com.udistrital.parcial2.modelo.Reporte;
import java.time.LocalDate;

public class PieConFechaDecorador extends ReporteDecorador {
    public PieConFechaDecorador(Reporte reporte) {
        super(reporte); //sup
    }

    @Override
    public String generarContenido() {
        ConfiguracionSistema configuracion = ConfiguracionSistema.getInstancia();
        return super.generarContenido()
                + "\nPie de página: Fecha " + LocalDate.now()
                + " | Directorio de salida: " + configuracion.getDirectorioSalida();
    }
}
