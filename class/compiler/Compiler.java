package compiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import scanner.Scanner;
import parser.Parser; // Importa el parser generado
import java_cup.runtime.Symbol; // Importa la clase Symbol de CUP

public class Compiler {
    public static void main(String[] args) {
        String inputFile = null;
        String outputFile = "output.txt";
        Set<String> debugStages = new HashSet<>();

        // Parse command-line arguments
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (i + 1 < args.length) {
                        outputFile = args[++i];
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
                        System.err.println("Unknown option: " + args[i]);
                        return;
                    }
                    inputFile = args[i];
                    break;
            }
        }

        if (inputFile == null) {
            printHelp();
            return;
        }

        try {
            BufferedReader reader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

            // Crear el scanner a partir del archivo de entrada
            Scanner scanner = new Scanner(reader);

            // Crear el parser a partir del scanner
            Parser parser = new Parser(scanner);

            writer.write("stage: parsing\n");

            // Ejecutar el parser
            Symbol result = parser.parse(); // El parser devuelve un resultado que puedes utilizar más adelante

            // Aquí puedes agregar más acciones según lo que devuelva el parser
            writer.write("Parsing completed successfully!\n");

            writer.close();
            reader.close();
        } catch (IOException e) {
            System.err.println("Error handling file: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error during parsing: " + e.getMessage());
        }
    }

    private static void printHelp() {
        System.out.println("Usage: java compiler [option] <filename>");
        System.out.println("Options:");
        System.out.println("  -o <outname>    Escribir el output a <outname>");
        System.out.println("  -debug <stage>  Información de debugging para la etapa especificada");
    }
}
