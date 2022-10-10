package machine;

import java.util.Scanner;

public class Console {
    private static final Scanner SCANNER = new Scanner(System.in);

    public static String readLine() {
        return SCANNER.nextLine();
    }

    public static int readInt() {
        return SCANNER.nextInt();
    }

    public static void writeLine(String line) {
        System.out.println(line);
    }
}
