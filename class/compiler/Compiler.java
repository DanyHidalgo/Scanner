package compiler;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import parser.Parser;
import scanner.Scanner;

public class Compiler {

    private static PrintWriter out;
    private static boolean debugging = false;
    private static List<String> debugStages;

    public static void main(String[] args) {
        try {
            // Parse command-line arguments
            if (args.length == 0) {
                printHelp();
                return;
            }

            String outputFileName = null;
            String targetStage = "codegen";
            String optStage = null;
            boolean optFlag = false;

            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-o" -> {
                        if (i + 1 < args.length) {
                            outputFileName = args[++i];
                        } else {
                            System.err.println("Error: Missing argument for -o");
                            return;
                        }
                    }
                    case "-target" -> {
                        if (i + 1 < args.length) {
                            targetStage = args[++i];
                        } else {
                            System.err.println("Error: Missing argument for -target");
                            return;
                        }
                    }
                    case "-opt" -> {
                        if (i + 1 < args.length) {
                            optStage = args[++i];
                            optFlag = true;
                        } else {
                            System.err.println("Error: Missing argument for -opt");
                            return;
                        }
                    }
                    case "-debug" -> {
                        if (i + 1 < args.length) {
                            debugStages = Arrays.asList(args[++i].split(":"));
                            debugging = true;
                        } else {
                            System.err.println("Error: Missing argument for -debug");
                            return;
                        }
                    }
                    default -> {
                        if (args[i].startsWith("-")) {
                            System.err.println("Error: Unknown option " + args[i]);
                            return;
                        }
                        // Assume file name if no options match
                    }
                }
            }

            // Set output file
            if (outputFileName != null) {
                out = new PrintWriter(new FileWriter(outputFileName));
            } else {
                out = new PrintWriter(System.out);
            }

            // Run stages based on the target
            String inputFileName = args[args.length - 1];
            Scanner scanner = new Scanner(inputFileName);

            if (debugging && debugStages.contains("scan")) {
                System.out.println("Debugging scan");
            }

            if ("scan".equals(targetStage)) {
                printStage("scanning");
                scanner.scan();
                return;
            }

            Parser parser = new Parser(scanner);

            if (debugging && debugStages.contains("parse")) {
                System.out.println("Debugging parse");
            }

            if ("parse".equals(targetStage)) {
                printStage("parsing");
                parser.parse();
                return;
            }

            Ast ast = new Ast(parser);

            if (debugging && debugStages.contains("ast")) {
                System.out.println("Debugging ast");
            }

            if ("ast".equals(targetStage)) {
                printStage("ast");
                ast.generate();
                return;
            }

            Semantic semantic = new Semantic(ast);

            if (debugging && debugStages.contains("semantic")) {
                System.out.println("Debugging semantic");
            }

            if ("semantic".equals(targetStage)) {
                printStage("semantic");
                semantic.check();
                return;
            }

            Irt irt = new Irt(semantic);

            if (debugging && debugStages.contains("irt")) {
                System.out.println("Debugging irt");
            }

            if ("irt".equals(targetStage)) {
                printStage("irt");
                irt.generate();
                return;
            }

            Codegen codegen = new Codegen(irt);

            if (debugging && debugStages.contains("codegen")) {
                System.out.println("Debugging codegen");
            }

            printStage("codegen");
            codegen.generate();

            if (optFlag) {
                applyOptimization(optStage);
            }

            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void printHelp() {
        System.out.println("Usage: java compiler [option] <filename>");
        System.out.println("Options:");
        System.out.println("-o <outname>       Write output to <outname>");
        System.out.println("-target <stage>    Specify the target stage (scan, parse, ast, semantic, irt, codegen)");
        System.out.println("-opt <opt_stage>   Perform the specified optimization (constant, algebraic)");
        System.out.println("-debug <stage>     Print debugging information for the specified stage(s) (scan:parse:...)");
    }

    private static void printStage(String stage) {
        out.println("stage: " + stage);
    }

    private static void applyOptimization(String optStage) {
        switch (optStage) {
            case "constant":
                printStage("optimizing: constant folding");
                break;
            case "algebraic":
                printStage("optimizing: algebraic simplification");
                break;
            default:
                System.err.println("Unknown optimization stage: " + optStage);
                break;
        }
    }
}
