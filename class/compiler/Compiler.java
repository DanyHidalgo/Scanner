package compiler;

import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import scanner.Scanner;

public class Compiler {
    public static void main(String[] args) {
        try {
            // Open the source file for reading
            FileReader reader = new FileReader("class/compiler/input.txt");
            Scanner scanner = new Scanner(reader);

            // Open the destination file for writing the results
            BufferedWriter writer = new BufferedWriter(new FileWriter("class/compiler/output.txt"));

            // Process the input file and extract tokens
            while (true) {
                String token = scanner.yylex(); // Fetch the next token
                if (token == null)
                    break; // Stop when there are no more tokens

                // Check for error messages and handle them
                if (token.startsWith("Error")) {
                    System.err.println(token); // Print error to standard error
                } else {
                    // Write the scanned token to the output file
                    writer.write(token);
                    writer.newLine();
                }
            }

            System.out.println("Scanning finished. Results saved to output.txt.");

            // Close the writer to finalize the output
            writer.close();
        } catch (IOException e) {
            System.err.println("Error handling file: " + e.getMessage());
        }
    }
}
