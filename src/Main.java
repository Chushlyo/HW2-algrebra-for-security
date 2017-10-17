import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    int userChoice;
    //Polynomial structure
    Polynomial polynomial;
    int a,x;
    //Field structure
    Field field;
    int exponent, prime;


    void computation() {
        System.out.println("Choose one of the operations: \n " +
                "   Objects to be constructed:\n" +
                "1. Integer modulus p, where p is prime.\n" +
                "2. Polynomials with integer coefficients mod p.\n" +
                "3. Finite Field with p^n elements.\n" +
                "   Arithmetic with polynomials:\n" +
                "4. Two polynomials with coefficients modulo prime, produce sum, scalar multiple,difference and product.\n" +
                "5. Quotient and remainder of two polynomials(long division).\n" +
                "6.Extented Euclidean algorithm for two polynomials with coefficients mod p.\n" +
                "7. Decide whether two polynomials in mod p are equal to third polynomial mod p.\n" +
                "   Arithmetic in finite fields:\n" +
                "8. Addition and multiplication tables of irreducible polynomial.\n" +
                "9.Produce sum, product and quotient of two irreducible polynomials from the same field.\n" +
                "10. Test irreducibility of polynomial mod p and produce irreducible polynomials of prescribed degree.");
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();
        switch (userChoice) {
            case 1:
                break;
            case 2:
                System.out.println("Enter modulus p.");
                a=scanner.nextInt();
                x=scanner.nextInt();
                polynomial=new Polynomial(a,x);
                break;
            case 3:
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter the exponent n.");
                exponent = scanner.nextInt();
                field = new Field(prime, exponent);
                field.generate();
                field.print();
                System.out.println("\n The field consists of " + field.field.size() + " elements.");
                break;
            case 4:
                break;
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                //two polynomials should be from the same field, check needs to be done
                break;
            case 10:
                break;

        }

    }

    boolean primeCheck(int p) {
        if (p == 2) {
            return true;
        }
        if (p % 2 == 0) return false;// the number is even
        for (int i = 3; i * i <= p; i += 2) { //check of being divisible by odd number
            if (p % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        new Main().computation();
    }
}
