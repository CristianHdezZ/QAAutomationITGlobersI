package co.com.itglobers.certification.testqa.util;


import org.hamcrest.MatcherAssert;

import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;



public class MetodosComunes {

    private static Handler fileHandler;

    private static void generarLogger(String strNombreLoger) {
        try {
            // crearCarpetaLogger();
            SimpleFormatter simpleFormatter = new SimpleFormatter();
            fileHandler = new FileHandler("./target/site/serenity/_" + strNombreLoger + ".log", false);
            fileHandler.setFormatter(simpleFormatter);
            Constant.LOG_ITGLOBERS.addHandler(fileHandler);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void cerrarLogger() {
        try {
            fileHandler.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void adicionarLog(Level level, String strMensaje) {
        Constant.LOG_ITGLOBERS.log(level, strMensaje);
        if (level.equals(Level.SEVERE)) {
            MatcherAssert.assertThat(String.format("Fallo el escenario debido a: %s", strMensaje), false);
        }else {
            MatcherAssert.assertThat(String.format("Escenario Exitoso debido a: %s", strMensaje), true);
        }
    }
}