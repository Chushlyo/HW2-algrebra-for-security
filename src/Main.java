import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Main {
    //user choice for operation
    int userChoice;
    //Polynomial structure
    NewPolynomial p,p1,p3,p4;
    //Field structure
    Field field;
    int exponent, prime;
    //User Input
    String poly, poly1;
    //Long division
    LongDivision longDivision;
    //Extended Euclidean
    ExtendedEuclidean extendedEuclidean;


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
        switch (userChoice) {
            case 1:
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                break;
            case 2:
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!primeCheck(prime)) {
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
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!primeCheck(prime)) {
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
            case 5:
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!primeCheck(prime)) {
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
                break;
            case 6:
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!primeCheck(prime)) {
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
                extendedEuclidean=new ExtendedEuclidean();
                extendedEuclidean.compute(p,p1);
                break;
            case 7:
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
                field.getPoly();
//                System.out.println("\n The field consists of " + field.field.size() + " elements.");
                break;
            case 8:
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter the exponent n.");
                exponent = scanner.nextInt();
                NewField sfield = new NewField(prime, exponent);
//                sfield.generate();
                break;
            case 9:
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter the exponent n.");
                exponent = scanner.nextInt();
                NewField pfield = new NewField(prime, exponent);
                
                System.out.println("Enter a prime number p");
                prime = scanner.nextInt();
                if (!primeCheck(prime)) {
                    System.out.println("The number is not prime.");
                    System.exit(0);
                }
                System.out.println("Enter a polynomial.");
                poly = scanner.next();
                p = new NewPolynomial(poly);
                p.convertPrime(prime);
                FieldTable table = new FieldTable(pfield,p);
                break;
                //two polynomials should be from the same field, check needs to be done
                
            case 10:
                System.out.println(-1%2);
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

    public Polynomial readPolynomial(String poly) {

        int i = 1;
        Polynomial[] p = new Polynomial[500];

        int firstCoef;

        //If the first thing you read is x, then the coef is 1
        if (poly.substring(0, 1).equals("x")) {
            firstCoef = 1;
        }
        int k = 0;

        //if it is not x find out what the coef is
        while (!poly.substring(k, k + 1).equals("x")) {
            k++;
            //if it is of ^0 then you need this
            if (k >= poly.length()) break;
        }
        firstCoef = Integer.valueOf(poly.substring(0, k));

        //the string without the coef
        poly = poly.substring(k, poly.length());


        if (poly.length() == 0) return new Polynomial(firstCoef, 0);
        //if of ^0 return 

        if (poly.length() == 1) return new Polynomial(firstCoef, 1);
        //if^1 without^0 return here

        //if it is of bigger degree than 1 Go here
        if (poly.substring(1, 2).equals("^")) {

            //the first polynomial
            p[0] = new Polynomial(firstCoef, Integer.valueOf(poly.substring(2, 3)));

            poly = poly.substring(3, poly.length());

            while (poly.length() > 0) {

                if (poly.substring(0, 1).equals("x")) {
                    firstCoef = 1;
                }
                k = 0;

                while (!poly.substring(k, k + 1).equals("x")) {
                    k++;
                    if (k >= poly.length()) break;
                }

                firstCoef = Integer.valueOf(poly.substring(0, k));


                poly = poly.substring(k, poly.length());


                if (poly.length() == 0) {
                    p[i] = new Polynomial(firstCoef, 0);
                    p[i].print();
                    break;
                }
                //if of ^0 return

                if (poly.length() == 1) {
                    p[i] = new Polynomial(firstCoef, 1);
                    p[i].print();
                    break;
                }
                //if^1 without^0 return here

                if (poly.substring(1, 2).equals("^")) {
                    p[i] = new Polynomial(firstCoef, Integer.valueOf(poly.substring(2, 3)));
                    poly = poly.substring(3, poly.length());
                } else {
                    p[i] = new Polynomial(firstCoef, 1);
//                    p[i].print();
                    p[i + 1] = new Polynomial(Integer.valueOf(poly.substring(2, poly.length())), 0);
//                    p[i+1].print();
                    break;
                }

                i++;
            }
        } else {
            p[0] = new Polynomial(firstCoef, 1);
            p[0].print();
            p[1] = new Polynomial(Integer.valueOf(poly.substring(2, poly.length())), 0);
            p[1].print();

        }


//        p[0] = p[0].plus(p[1]);
        p[0] = p[0].plus(p[1]);
        p[0].print();


//        p[i-1].print();
//        System.out.println("here+" + poly);


//        
//        if(!poly.substring(0,1).equals("x")){
//            
//            firstCoef = Integer.valueOf(poly.substring(0,1));
//            poly = poly.substring(3,poly.length());
//        }
//        else {
//            poly = poly.substring(2,poly.length());
//            firstCoef=1;
//        }
////        System.out.println(firstCoef);
//        int highDegree=Integer.valueOf(poly.substring(0,1));
//        
//        p[0] = new Polynomial(firstCoef,highDegree);
//        
//        poly=poly.substring(2,poly.length());
////        p[0].print();
////       System.out.println("xxx  "+poly);
//        
//        while(poly.length()>4){
//            if(!poly.substring(0,1).equals("x")){
//                firstCoef = Integer.valueOf(poly.substring(0,1));
//                poly = poly.substring(3,poly.length());
//            }
//            else {
//                poly = poly.substring(2,poly.length());
//                firstCoef=1;
//            }
//            System.out.println(firstCoef);
//          
//            highDegree=Integer.valueOf(poly.substring(0,1));
//
//            p[i] = new Polynomial(firstCoef,highDegree);
//            p[i].print();
//            poly=poly.substring(2,poly.length());
//        }
//        
//        if(poly.length()==4){
//            
//        }
//        
//                    
//        
//        
//        
//        
////        int kk = poly.length()/5;//poly.charAt(3);
////        System.out.println(kk);
////        int[] readPoly = new int[kk];
//        

        return p[0];

    }

    public static void main(String[] args) {
        new Main().computation();
    }
}
