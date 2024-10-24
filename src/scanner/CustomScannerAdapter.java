package scanner;

import java.io.IOException;
import java_cup.runtime.Symbol;

public class CustomScannerAdapter implements java_cup.runtime.Scanner {
    private Scanner myScanner;

    public CustomScannerAdapter(Scanner scanner) {
        this.myScanner = scanner;
    }

    @Override
    public Symbol next_token() throws IOException {
        return myScanner.next_token(); // Método de tu escáner personalizado
    }
}
