package compiler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.StringReader; // Importa StringReader

import java_cup.runtime.Symbol;
import scanner.Scanner;

public class Compiler {
    public static void main(String[] args) {
        try {
            // Open the source file for reading
            BufferedReader reader = new BufferedReader(new FileReader("class/compiler/input.txt"));
            Scanner scanner = new Scanner(reader);

            // Open the destination file for writing the results
            BufferedWriter writer = new BufferedWriter(new FileWriter("class/compiler/output.txt"));

            String line;
            String token;
            boolean lineEndedCorrectly;

            // Process each line from the input file
            while ((line = reader.readLine()) != null) {
                StringBuilder processedLine = new StringBuilder();
                lineEndedCorrectly = false;

                // Process tokens for the current line
                scanner.yyreset(new StringReader(line)); // Reset scanner for the new line

                while ((token = scanner.yylex()) != null) {
                    // Check if the token is a semicolon and mark the line as ended correctly
                    if (token.equals("Symbol: ;")||(token.equals(("Symbol: {")))||(token.equals(("Symbol: }")))) {
                        lineEndedCorrectly = true;
                    }
                    processedLine.append(token).append("\n");
                }

                // Check if the line ended correctly with a semicolon
                if (!lineEndedCorrectly) {
                    processedLine.append("Error: Missing semicolon, { or }at the end of the line.");
                }

                // Write the processed line to the output file
                writer.write(processedLine.toString());
            }

            System.out.println("Scanning finished. Results saved to output.txt.");

            // Close the writer to finalize the output
            writer.close();
            reader.close();
        } catch (IOException e) {
            System.err.println("Error handling file: " + e.getMessage());
        }
    }
}
