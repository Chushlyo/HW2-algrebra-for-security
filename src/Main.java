import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by Nikolay on 01-Oct-17.
 */

public class Main {
    Polynomial polynomial;
    Field field;
    int modulus,coefficient;
    void computation(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a polynomial");
        coefficient = scanner.nextInt();
        System.out.println("Enter the modulus");
        modulus = scanner.nextInt();
        field= new Field(coefficient,modulus);
        field.generate();
        field.print();

    }

    public static void main(String[] args) {
        new Main().computation();
    }
}
