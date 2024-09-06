package compiler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import scanner.Scanner;

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

            // Create and use the Scanner
            Scanner scanner = new Scanner(reader);
            if (debugStages.contains("scan")) {
                System.out.println("Debugging scan");
            }

            writer.write("stage: scanning\n");

            // Process the entire file using the scanner
            String token;
            while ((token = scanner.yylex()) != null) {
                writer.write(token + "\n");
            }

            writer.close();
            reader.close();
        } catch (IOException e) {
            System.err.println("Error handling file: " + e.getMessage());
        }
    }

    private static void printHelp() {
        System.out.println("Usage: java compiler [option] <filename>");
        System.out.println("Options:");
        System.out.println("  -o <outname>    Escribir el output a <outname>");
        System.out.println("  -debug <stage>  Información de debugging para la etapa especificada");
    }
}
