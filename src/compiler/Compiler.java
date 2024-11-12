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
import ast.*;  // Importar las clases del AST

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
        String outputAstFileName = "ast.dot"; // Archivo de salida para el AST en formato DOT
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
                // Crear PrintStream para capturar la salida del parser
                PrintStream parserOutput = new PrintStream(new File(outputParserFileName)); // <-- Corrected this line

                // Redirigir System.out para escribir en output_parser.txt
                System.setOut(parserOutput);

                Parser parser = new Parser(scanner);
                ProgramNode program = (ProgramNode) parser.parse().value; // Ejecutar el análisis sintáctico

                // Ahora tenemos el AST como un objeto ProgramNode, por ejemplo.
                // Escribimos el AST en formato DOT para Graphviz

                try (BufferedWriter astWriter = new BufferedWriter(new FileWriter(outputAstFileName))) {
                    astWriter.write("digraph AST {\n");
                    program.generateDot(astWriter);  // Método que recorre y escribe el DOT de tu AST
                    astWriter.write("}\n");
                }

                // Cerrar la salida del parser
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
