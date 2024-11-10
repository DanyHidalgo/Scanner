package compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import parser.Parser;
import parser.sym;
import scanner.Scanner;
import java_cup.runtime.Symbol;
import java.io.PrintWriter;
import java.io.PrintStream;
import java.io.File; // <-- Import the File class

public class Compiler {

    public static void main(String[] args) {
        // Validar argumentos
        if (args.length < 1) {
            System.err.println(
                    "Uso: java Compiler -target [scan|parse|ast|semantic|irt|codegen] -opt [constant|algebraic] -debug [scan:parse:etc] -o [outputfile] filename");
            System.exit(1);
        }

        String target = null;
        String opt = null;
        String debug = null;
        String outputFileName = "output.txt"; // Archivo de salida por defecto para el escaneo
        String outputParserFileName = "parser.txt"; // Archivo de salida por defecto para el parser
        String inputFileName = null;

        // Procesar los argumentos
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-target":
                    target = args[++i];
                    break;
                case "-opt":
                    opt = args[++i];
                    break;
                case "-debug":
                    debug = args[++i];
                    break;
                case "-o":
                    outputFileName = args[++i];
                    break;
                default:
                    inputFileName = args[i];
                    break;
            }
        }

        if (inputFileName == null) {
            System.err.println("Debe proporcionar un archivo de entrada.");
            System.exit(1);
        }

        try {
            // Abrir archivo de entrada para leer
            BufferedReader reader = new BufferedReader(new FileReader(inputFileName));
            Scanner scanner = new Scanner(reader);

            // Abrir archivo de salida para escribir los resultados
            BufferedWriter writer = null;

            // Escanear tokens si target es "scan"
            if ("scan".equals(target)) {
                writer = new BufferedWriter(new FileWriter(outputFileName));
                Symbol token;
                while ((token = scanner.next_token()) != null) {
                    // Asegúrate de usar el sym correcto
                    if (token.sym >= 0 && token.sym < sym.terminalNames.length) {
                        String tokenName = sym.terminalNames[token.sym];
                        String tokenValue = (token.value != null) ? token.value.toString() : "";
                        writer.write("Token: " + tokenName + " " + tokenValue + ", Línea: " + token.left + ", Columna: "
                                + token.right + "\n");
                    } else {
                        writer.write("Unknown token: " + token.sym + ", Línea: " + token.left + ", Columna: "
                                + token.right + "\n");
                    }
                }
            }
            // Ejecutar el parser si target es "parse"
            else if ("parse".equals(target)) {
                // Create PrintStream for capturing parser output
                PrintStream parserOutput = new PrintStream(new File(outputParserFileName)); // <-- Corrected this line

                // Redirect System.out to write into output_parser.txt
                System.setOut(parserOutput);

                Parser parser = new Parser(scanner);
                parser.parse(); // Ejecutar el análisis sintáctico

                // Close the parser output stream
                parserOutput.close();
            }

            if (writer != null) {
                writer.close();
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Error manejando archivo: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error durante el análisis sintáctico: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
