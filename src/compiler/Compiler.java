package compiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import scanner.Scanner; // Tu escáner personalizado
import scanner.CustomScannerAdapter; // Importar el adaptador personalizado
import java_cup.runtime.Symbol;
import parser.Parser; // Importar el parser
import parser.sym;

public class Compiler {
    public static void main(String[] args) {
        String inputFilePath = null;
        String outputFilePath = "output.txt";
        Set<String> debugStages = new HashSet<>();

        // Procesar argumentos de línea de comandos
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (i + 1 < args.length) {
                        outputFilePath = args[++i];
                    }
                    break;
                case "-debug":
                    if (i + 1 < args.length) {
                        String[] stages = args[++i].split(":");
                        for (String stage : stages) {
                            debugStages.add(stage);
                        }
                    }
                    break;
                default:
                    if (args[i].startsWith("-")) {
                        System.err.println("Opción desconocida: " + args[i]);
                        return;
                    }
                    inputFilePath = args[i];
                    break;
            }
        }

        if (inputFilePath == null) {
            showUsageInstructions();
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath))) {

            // Crear el escáner personalizado
            Scanner myScanner = new Scanner(reader);
            CustomScannerAdapter adapter = new CustomScannerAdapter(myScanner);
            Parser parser = new Parser(adapter);

            writer.write("Etapa: escaneo\n");

            if (debugStages.contains("scan")) {
                System.out.println("Depurando la etapa de escaneo...");
            }

            // Procesar el archivo utilizando el escáner adaptado
            Symbol token;
            while ((token = adapter.next_token()) != null && token.sym != sym.EOF) {
                writer.write("Token: " + token.sym + " (" + token.value + ")\n");
                if (debugStages.contains("scan")) {
                    System.out.println("Token: " + token.sym + " (" + token.value + ")");
                }
            }

            // Usar el parser para analizar el archivo
            writer.write("\nEtapa: análisis sintáctico\n");
            if (debugStages.contains("parse")) {
                System.out.println("Depurando la etapa de análisis sintáctico...");
            }

            try {
                parser.parse();
                writer.write("Análisis completado.\n");
            } catch (Exception e) {
                writer.write("Error de análisis sintáctico: " + e.getMessage() + "\n");
                System.err.println("Error de análisis sintáctico: " + e.getMessage());
                parser.reportError(e.getMessage()); //si tu Parser tiene ese método
            }

        } catch (IOException e) {
            System.err.println("Error al manejar el archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error durante el procesamiento: " + e.getMessage());
            e.printStackTrace(); // Para ayudar a depurar en caso de error
        }
    }

    private static void showUsageInstructions() {
        System.out.println("Uso: java compiler [opción] <nombre del archivo>");
        System.out.println("Opciones:");
        System.out.println("  -o <nombreSalida>    Escribir salida en <nombreSalida>");
        System.out.println("  -debug <etapa>      Información de depuración para la etapa especificada (scan:parse)");
    }
}
