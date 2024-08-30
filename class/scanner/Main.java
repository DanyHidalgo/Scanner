package scanner;
import java.io.FileReader;
import java.io.IOException;

import parser.sym;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(new FileReader("test.txt"));
            sym symbol;
            while ((symbol = scanner.next_token()).sym != sym.EOF) {
                System.out.println("Token: " + symbol);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
