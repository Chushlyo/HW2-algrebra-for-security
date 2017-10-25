import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    //user choice for operation
    int userChoice;
    //Polynomial structure
    NewPolynomial p,p1,p3,p4;
    //Field structure
    int exponent, prime;
    //User Input
    String poly, poly1,poly2;
    //Long division
    LongDivision longDivision;
    //Extended Euclidean
    ExtendedEuclidean extendedEuclidean;
    //Irreducibility check
    Irreducibility irreducibility;
    //Congruence
    EqualModulo equalModulo;
    IntegerMod integerMod;

    void computation() {
        System.out.println("Choose one of the operations: \n " +
                "   Objects to be constructed:\n" +
                "1. Integer modulus p, where p is prime.\n" +
                "2. Polynomials with integer coefficients mod p.\n" +
                "3. Finite Field with p^n elements.\n" +
                "   Arithmetic with polynomials:\n" +
                "4. Two polynomials with coefficients modulo prime, produce sum, scalar multiple,difference and product.\n" +
                "5. Quotient and remainder of two polynomials(long division).\n" +
                "6. Extended Euclidean algorithm for two polynomials with coefficients mod p.\n" +
                "7. Decide whether two polynomials in mod p are equal to third polynomial mod p.\n" +
                "   Arithmetic in finite fields:\n" +
                "8. Addition and multiplication tables of irreducible polynomial.\n" +
                "9.Produce sum, product and quotient of two irreducible polynomials from the same field.\n" +
                "10. Test irreducibility of polynomial mod p and produce irreducible polynomials of prescribed degree.");
        Scanner scanner = new Scanner(System.in);
        userChoice = scanner.nextInt();
        integerMod = new IntegerMod();
        switch (userChoice) {
            case 1://integer mod
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!integerMod.primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter an Integer");
                int integer = scanner.nextInt();
                IntegerMod im = new IntegerMod();
                System.out.println(im.modReduction(prime,integer));
                break;
            case 2://Polynomials with integer coefficients
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!integerMod.primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter a polynomial.");
                poly = scanner.next();
                p = new NewPolynomial(poly);                
                p.print();
                p.convertPrime(prime);
                p.print();
                break;
            case 3://Finite fields
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!integerMod.primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter the exponent n.");
                exponent = scanner.nextInt();
                NewField field1= new NewField(prime,exponent);
                field1.generate();
                field1.printField();
                System.out.println("\n The field consists of " + field1.fieldPoly.size() + " elements.");
                break;
            case 4://arithmetic polynomials
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!integerMod.primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter first polynomial.");
                poly = scanner.next().toLowerCase();
                p = new NewPolynomial(poly);
                p.print();
                p.convertPrime(prime);
                p.print();
                System.out.println("Enter second polynomial.");
                poly1 = scanner.next().toLowerCase();
                p1 = new NewPolynomial(poly1);
                p1.print();
                p1.convertPrime(prime);
                p1.print();
                System.out.println("Enter a scalar");
                int scalar = scanner.nextInt();
                PolynomialsArithmetic arithmetic = new PolynomialsArithmetic();
                System.out.println("The sum of both polynomials is:");
                NewPolynomial res1= arithmetic.sum(p, p1);
                res1.convertPrime(prime);
                res1.print();
                System.out.println("Subtracting the second polynomial from the first one gives:");
                NewPolynomial res2= arithmetic.difference(p, p1);
                res2.convertPrime(prime);
                res2.print();
                System.out.println("Subtracting the first polynomial from the second one gives:");
                arithmetic.difference(p1, p).print();
                NewPolynomial res3= arithmetic.difference(p1, p);
                res3.convertPrime(prime);
                res3.print();
                System.out.println("The scalar multiple of first polynomial is ");
                NewPolynomial res4= arithmetic.scalar(p, scalar);
                res4.convertPrime(prime);
                res4.print();
                System.out.println("The scalar multiple of second polynomial is ");
                NewPolynomial res5= arithmetic.scalar(p1, scalar);
                res5.convertPrime(prime);
                res5.print();
                p3 = new NewPolynomial(poly);
                p3.convertPrime(prime);
                p4 = new NewPolynomial(poly1);
                p4.convertPrime(prime);
                System.out.println("The product is");
                NewPolynomial res= arithmetic.product(p3, p4);
                res.convertPrime(prime);
                res.print();
                break;
            case 5://long division
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!integerMod.primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter first polynomial.");
                poly = scanner.next().toLowerCase();
                p = new NewPolynomial(poly);
                p.print();
                p.convertPrime(prime);
                p.print();
                System.out.println("Enter second polynomial.");
                poly1 = scanner.next().toLowerCase();
                p1 = new NewPolynomial(poly1);
                p1.print();
                p1.convertPrime(prime);
                p1.print();
                longDivision=new LongDivision(prime);
                longDivision.divide(p,p1);
                System.out.println("Quotient is");
                longDivision.quot.print();
                System.out.println("Reminder is");
                longDivision.rem.print();
                break;
            case 6://extended euclidean
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!integerMod.primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter first polynomial.");
                poly = scanner.next().toLowerCase();
                p = new NewPolynomial(poly);
                p.print();
                p.convertPrime(prime);
                p.print();
                System.out.println("Enter second polynomial.");
                poly1 = scanner.next().toLowerCase();
                p1 = new NewPolynomial(poly1);
                p1.print();
                p1.convertPrime(prime);
                p1.print();
                extendedEuclidean=new ExtendedEuclidean(prime);
                extendedEuclidean.compute(p,p1);
                System.out.println("GCD is ");
                extendedEuclidean.gcd.print();
                
                System.out.println("Y is");
                extendedEuclidean.y1.print();
                System.out.println("X is");
                extendedEuclidean.x1.print();
            break;
            case 7://two polynomials equal third one
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!integerMod.primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter first polynomial.");
                poly = scanner.next().toLowerCase();
                p = new NewPolynomial(poly);
                p.print();
                p.convertPrime(prime);
                p.print();
                System.out.println("Enter second polynomial.");
                poly1 = scanner.next().toLowerCase();
                p1 = new NewPolynomial(poly1);
                p1.print();
                p1.convertPrime(prime);
                p1.print();
                System.out.println("Enter third polynomial.");
                poly2 = scanner.next().toLowerCase();
                p3 = new NewPolynomial(poly2);
                p3.print();
                p3.convertPrime(prime);
                p3.print();
                equalModulo=new EqualModulo(p,p1,p3,prime);
                equalModulo.congruent();
                break;
            case 8://addition multiplication table
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!integerMod.primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter the exponent n.");
                exponent = scanner.nextInt();
                NewField sfield = new NewField(prime, exponent);
                sfield.generate();
                System.out.println("Enter a polynomial.");
                poly = scanner.next();
                p = new NewPolynomial(poly);
                p.print();
                p.convertPrime(prime);
                p.print();
                FieldTable table = new FieldTable(sfield,p);
                break;
            case 9:// arithmetic finite fields
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!integerMod.primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter the exponent n.");
                exponent = scanner.nextInt();
                NewField pfield = new NewField(prime, exponent);
                pfield.generate();
                System.out.println("Enter first polynomial.");
                poly = scanner.next().toLowerCase();
                p = new NewPolynomial(poly);
                p.print();
                p.convertPrime(prime);
                if(!pfield.checkIfInField(p)){
                    System.out.println("Element not in field.");
                    System.exit(0);
                }
                p.print();
                System.out.println("Enter second polynomial.");
                poly1 = scanner.next().toLowerCase();
                p1 = new NewPolynomial(poly1);
                p1.print();
                p1.convertPrime(prime);
                if(!pfield.checkIfInField(p1)){
                    System.out.println("Element not in field.");
                    System.exit(0);
                }
                p1.print();
                NewPolynomial p2 = new NewPolynomial("x^"+exponent);
                FieldsArithmetic fa = new FieldsArithmetic(p,p1,p2,prime);
                System.out.println("Sum is:");
                fa.sum().print();
                System.out.println("Product is:");
                fa.product().print();
                System.out.println("Quotient is:");
                if(fa.quotient()!=null)
                    fa.quotient().print();
                else System.out.println("There is no inverse");
                
                break;
                //two polynomials should be from the same field, check needs to be done
                
            case 10: // irreducibility
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!integerMod.primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter a polynomial.");
                poly = scanner.next();
                p = new NewPolynomial(poly);
                if(p.getDegree()<1){
                    System.out.println("Polynomial should have a degree at least 1.");
                    System.exit(0);
                }
                p.printWL();
                p.convertPrime(prime);
                p.printWL();
                irreducibility=new Irreducibility(p,prime);
                irreducibility.checkIrreducibility();
                break;

        }

    }
    public static void main(String[] args) {
        new Main().computation();
    }
}
