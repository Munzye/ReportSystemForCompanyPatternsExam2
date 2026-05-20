package com.udistrital.parcial2;

import com.udistrital.parcial2.config.ConfiguracionSistema;
import com.udistrital.parcial2.decorator.EncabezadoDecorador;
import com.udistrital.parcial2.decorator.MarcaAguaDecorador;
import com.udistrital.parcial2.decorator.PieConFechaDecorador;
import com.udistrital.parcial2.factory.ReporteFactory;
import com.udistrital.parcial2.modelo.Reporte;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); //tr

        ConfiguracionSistema configuracion = ConfiguracionSistema.getInstancia();
        configuracion.setDirectorioSalida("/salida/reportes");
        configuracion.setFormatoPorDefecto("PDF");
        configuracion.setMostrarMarcaAgua(true);

        System.out.println("Configuración actual del sistema:");
        System.out.println(configuracion);
        System.out.println();

        System.out.print("Ingrese el tipo de reporte que desea crear (PDF, EXCEL o HTML): ");
        String tipo = scanner.nextLine();

        ReporteFactory factory = new ReporteFactory();
        Reporte reporte = factory.crearReporte(tipo);

        reporte = new EncabezadoDecorador(reporte, "Reporte empresarial");
        reporte = new MarcaAguaDecorador(reporte, "CONFIDENCIAL");
        reporte = new PieConFechaDecorador(reporte);

        System.out.println();
        System.out.println("Contenido generado:");
        System.out.println(reporte.generarContenido());

        demostrarSingleton();
        scanner.close();
    }

    private static void demostrarSingleton() {
        ConfiguracionSistema configuracionDesdeOtraParte = ConfiguracionSistema.getInstancia();

        System.out.println();
        System.out.println("Acceso a la misma configuración desde otra parte en el codigo:");
        System.out.println("Formato por defecto: " + configuracionDesdeOtraParte.getFormatoPorDefecto());
        System.out.println("Directorio de salida: " + configuracionDesdeOtraParte.getDirectorioSalida());
    }
}
   
