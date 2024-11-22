package compiler;

import scanner.Scanner;
import parser.sym;
import parser.Parser;
import ast.Program;
import ast.ASTPrinter;
import ast.ASTDotGenerator;
import semantic.SemanticAnalyzer;
import irt.IRTreeGenerator;
import irt.BasicBlock;
import irt.IRResult;
import java_cup.runtime.Symbol;

import java.io.*;
import java.util.List;

public class Compiler {

    public static void main(String[] args) {
        // Argumentos básicos del compilador
        String filename = "";
        String output = "output_scan.txt";
        String target = "scan";
        boolean debug = false;

        // Procesar argumentos de entrada
        for (int i = 0; i < args.length; i++) {
            switch (args[i]) {
                case "-o":
                    if (i + 1 < args.length) {
                        output = args[++i];
                    } else {
                        printArgumentError("-o");
                    }
                    break;
                case "-target":
                    if (i + 1 < args.length) {
                        target = args[++i];
                    } else {
                        printArgumentError("-target");
                    }
                    break;
                case "-debug":
                    debug = true;
                    break;
                case "-h":
                    printHelp();
                    System.exit(0);
                    break;
                default:
                    filename = args[i];
            }
        }

        // Validación de archivo de entrada
        if (filename.isEmpty()) {
            System.err.println("Error: No se especificó un archivo de entrada.");
            printHelp();
            System.exit(1);
        }

        // Ejecución principal del compilador
        try {
            switch (target) {
                case "scan":
                    executeScan(filename, output, debug);
                    break;
                case "parse":
                    executeParse(filename, output, debug);
                    break;
                case "ast":
                    executeAST(filename, output, debug);
                    break;
                case "opt":
                    executeOptimization(filename, output, debug);
                    break;
                case "irt":
                    executeIRT(filename, output, debug); // NUEVO: Etapa de IR
                    break;
                case "codegen":
                    executeCodeGen(filename, output, debug);
                    break;
                default:
                    System.err.println("Error: Objetivo desconocido: " + target);
                    printHelp();
                    System.exit(1);
            }
        } catch (IOException e) {
            handleIOException(e, debug);
        }
    }

    /**
     * Ejecuta la etapa de escaneo.
     */
    private static void executeScan(String filename, String output, boolean debug) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(output))) {
            writer.println("stage: scanning");
            System.out.println("stage: scanning");

            Scanner scanner = new Scanner(new FileReader(filename));
            while (!scanner.yyatEOF()) {
                Symbol token = scanner.next_token();
                if (token.sym == sym.EOF)
                    break;

                String tokenName = sym.terminalNames[token.sym];
                String tokenValue = (token.value != null) ? token.value.toString() : "N/A";

                writer.printf("Token: %s | Valor: %s | Línea: %d | Columna: %d%n",
                        tokenName, tokenValue, token.left + 1, token.right + 1);

                if (debug) {
                    System.out.printf("Token: %s | Valor: %s | Línea: %d | Columna: %d%n",
                            tokenName, tokenValue, token.left + 1, token.right + 1);
                }
            }
        }
        System.out.println("Escaneo completado. Resultados en " + output);
    }

    /**
     * Ejecuta la etapa de parsing.
     */

    /*
     * private static void executeParse(String filename, String output, boolean
     * debug) throws IOException, Exception {
     * try (PrintWriter writer = new PrintWriter(new FileWriter(output))) {
     * writer.println("stage: parsing");
     * System.out.println("stage: parsing");
     * 
     * Scanner scanner = new Scanner(new FileReader(filename));
     * Parser parser = new Parser(scanner);
     * Symbol result = parser.parse();
     * 
     * if (result == null || result.value == null) {
     * writer.println("Error: No se pudo generar el AST.");
     * if (debug) {
     * System.err.println("Error: No se pudo generar el AST.");
     * }
     * return;
     * }
     * 
     * Program program = (Program) result.value;
     * writer.println("Parsing completado con éxito.");
     * if (debug) {
     * System.out.println("Parsing completado con éxito.");
     * }
     * 
     * performSemanticAnalysis(program, writer, debug);
     * }
     * 
     * System.out.println("Parsing completado. Resultados en " + output);
     * }
     */

    private static void executeParse(String filename, String output, boolean debug) throws IOException {
        // Validar que el archivo de entrada exista y sea legible
        File inputFile = new File(filename);
        if (!inputFile.exists() || !inputFile.canRead()) {
            throw new IOException("El archivo de entrada no existe o no es legible: " + filename);
        }

        try (PrintWriter writer = new PrintWriter(new FileWriter(output))) {
            writer.println("stage: parsing");
            System.out.println("stage: parsing");

            // Inicializar el escáner y el parser
            Scanner scanner = new Scanner(new FileReader(inputFile));
            Parser parser = new Parser(scanner);

            try {
                // Realizar el análisis sintáctico
                Symbol result = parser.parse();
                if (result == null || result.value == null) {
                    writer.println("Error: No se pudo generar el AST.");
                    if (debug) {
                        System.err.println("Error: No se pudo generar el AST.");
                    }
                    return;
                }

                // Procesar el AST
                Program program = (Program) result.value;
                writer.println("Parsing completado con éxito.");
                if (debug) {
                    System.out.println("Parsing completado con éxito.");
                }

                // Realizar análisis semántico
                performSemanticAnalysis(program, writer, debug);
            } catch (Exception e) {
                // Manejo de errores durante el parsing
                writer.println("Error durante el análisis sintáctico: " + e.getMessage());
                if (debug) {
                    e.printStackTrace();
                }
                return;
            }
        }

        System.out.println("Parsing completado. Resultados en " + output);
    }

    private static void executeAST(String filename, String output, boolean debug) throws IOException {
        // Validar que el archivo de entrada exista y sea legible
        File inputFile = new File(filename);
        if (!inputFile.exists() || !inputFile.canRead()) {
            throw new IOException("El archivo de entrada no existe o no es legible: " + filename);
        }

        try (PrintWriter dotWriter = new PrintWriter(new FileWriter(output))) {
            System.out.println("stage: AST generation");

            // Inicializar el escáner y el parser
            Scanner scanner = new Scanner(new FileReader(inputFile));
            Parser parser = new Parser(scanner);

            try {
                // Realizar el análisis sintáctico
                Symbol result = parser.parse();
                if (result == null || !(result.value instanceof Program)) {
                    System.err.println("Error: No se pudo generar el AST.");
                    dotWriter.println("Error: No se pudo generar el AST.");
                    return;
                }

                // Procesar el AST y generar el archivo DOT
                Program program = (Program) result.value;
                ASTDotGenerator dotGenerator = new ASTDotGenerator(dotWriter);
                dotGenerator.beginGraph();
                program.accept(dotGenerator);
                dotGenerator.endGraph();

                System.out.println("Archivo DOT generado en " + output);

                // Generar PDF desde el archivo DOT
                generatePDF(output, debug);
            } catch (Exception e) {
                // Manejo de errores durante el análisis o la generación del AST
                dotWriter.println("Error durante la generación del AST: " + e.getMessage());
                if (debug) {
                    e.printStackTrace();
                }
                return;
            }
        }
    }

    /**
     * Realiza el análisis semántico.
     */
    private static void performSemanticAnalysis(Program program, PrintWriter writer, boolean debug) {
        SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
        program.accept(semanticAnalyzer);

        List<String> errors = semanticAnalyzer.getErrors();
        if (!errors.isEmpty()) {
            writer.println("Errores semánticos encontrados:");
            System.err.println("Errores semánticos encontrados:");
            for (String error : errors) {
                writer.println(error);
                System.err.println(error);
            }
        } else {
            writer.println("Análisis semántico completado sin errores.");
        }
    }

    /**
     * Genera un archivo PDF desde un archivo DOT.
     */
    private static void generatePDF(String dotFile, boolean debug) {
        String pdfFile = dotFile.replace(".dot", ".pdf");
        try {
            ProcessBuilder pb = new ProcessBuilder("dot", "-Tpdf", dotFile, "-o", pdfFile);
            pb.redirectErrorStream(true);
            Process process = pb.start();
            int exitCode = process.waitFor();
            if (exitCode == 0) {
                System.out.println("PDF generado exitosamente en " + pdfFile);
            } else {
                System.err.println("Error generando PDF. Código de salida: " + exitCode);
            }
        } catch (IOException | InterruptedException e) {
            System.err.println("Error generando PDF: " + e.getMessage());
            if (debug) {
                e.printStackTrace();
            }
        }
    }

    /**
    * Generación de código IRT
    **/

    private static void executeIRT(String filename, String output, boolean debug) throws IOException {
        try (PrintWriter writer = new PrintWriter(new FileWriter(output))) {
            writer.println("stage: IRT generation");
            System.out.println("stage: IRT generation");

            // Inicializar Scanner y Parser
            Scanner scanner = new Scanner(new FileReader(filename));
            Parser parser = new Parser(scanner);

            // Realizar el análisis sintáctico
            Symbol result = parser.parse();
            if (result == null || result.value == null) {
                writer.println("Error: No se pudo generar el AST.");
                return;
            }

            // Obtener el AST
            Program program = (Program) result.value;

            // Análisis semántico
            SemanticAnalyzer semanticAnalyzer = new SemanticAnalyzer();
            program.accept(semanticAnalyzer);

            List<String> semanticErrors = semanticAnalyzer.getErrors();
            if (!semanticErrors.isEmpty()) {
                writer.println("Errores semánticos encontrados:");
                for (String error : semanticErrors) {
                    writer.println(error);
                }
                return;
            }

            // Generar representación intermedia (IR)
            IRTreeGenerator irGenerator = new IRTreeGenerator();
            IRResult irResult = irGenerator.generateAndOptimize(program);

            if (irResult.errors.isEmpty()) {
                writer.println("\nGenerated Intermediate Representation:");
                if (irResult.ir != null) {
                    writer.println(irResult.ir.toString());
                } else {
                    writer.println("Error: La IR generada es nula.");
                }

                // Mostrar optimizaciones realizadas
                writer.println("\nOptimizations performed:");
                if (irResult.cfg != null && irResult.cfg.blocks != null) {
                    writer.println("- Número de bloques básicos: " + irResult.cfg.blocks.size());
                } else {
                    writer.println("- No se generó el CFG o no tiene bloques básicos.");
                }

                if (debug) {
                    writer.println("\nDebug Information:");
                    writer.println("- Basic blocks and their connections");
                    if (irResult.cfg != null) {
                        for (BasicBlock block : irResult.cfg.blocks) {
                            writer.println("  Block: " + block.label);
                            writer.println("  Predecessors: " + block.predecesores.size());
                            writer.println("  Successors: " + block.sucesores.size());
                            writer.println();
                        }
                    }
                }
            } else {
                writer.println("Errores durante la generación de IR:");
                for (String error : irResult.errors) {
                    writer.println(error);
                }
            }
        } catch (Exception e) {
            System.err.println("Error durante la generación de IR: " + e.getMessage());
            if (debug) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Simulación: Optimización del código intermedio.
     */
    private static void executeOptimization(String filename, String output, boolean debug) {
        System.out.println("Etapa de optimización aún no implementada.");
    }

    /**
     * Simulación: Generación de código.
     */
    private static void executeCodeGen(String filename, String output, boolean debug) {
        System.out.println("Etapa de generación de código aún no implementada.");
    }

    /**
     * Manejo de excepciones de entrada/salida.
     */
    private static void handleIOException(IOException e, boolean debug) {
        System.err.println("Error de E/S: " + e.getMessage());
        if (debug) {
            e.printStackTrace();
        }
    }

    /**
     * Mensaje de error para argumentos inválidos.
     */
    private static void printArgumentError(String argument) {
        System.err.println("Error: El argumento " + argument + " requiere un valor.");
        printHelp();
        System.exit(1);
    }

    /**
     * Muestra la ayuda del programa.
     */
    private static void printHelp() {
        System.out.println("Uso: java compiler.Compiler [option] <filename>");
        System.out.println("-o <outname>: Especifica el nombre del archivo de salida.");
        System.out.println("-target <stage>: scan, parse, ast, irt, codegen");
        System.out.println("-debug: Activa el modo debug.");
        System.out.println("-h: Muestra esta ayuda.");
    }
}