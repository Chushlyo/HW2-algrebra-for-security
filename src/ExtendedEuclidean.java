public class ExtendedEuclidean {
    PolynomialsArithmetic polynomialsArithmetic = new PolynomialsArithmetic();
    LongDivision longDivision = new LongDivision();
    NewPolynomial quot, xPr, yPr,gcd;
    NewPolynomial x1 = new NewPolynomial("1");
    NewPolynomial x2 = new NewPolynomial("0");
    NewPolynomial y2 = new NewPolynomial("1");
    NewPolynomial y1 = new NewPolynomial("0");

    void compute(NewPolynomial a, NewPolynomial b) {

        while (b.getDegree() != 0) {
            longDivision.divide(a, b);
            quot = longDivision.quot;
            a = b;
            b=longDivision.rem;
            System.out.println("b is ");
            b.print();
            xPr=polynomialsArithmetic.difference(x1,polynomialsArithmetic.product(quot,x2));
          // if(xPr.getDegree()>0) {
          NewPolynomial current=xPr.changeDegree(xPr.getDegree()-1,xPr);
            xPr=current;
        //   }
            yPr=polynomialsArithmetic.difference(y1,polynomialsArithmetic.product(quot,y2));
            x1=x2;
            y1=y2;
            x2=xPr;
            y2=yPr;
        }
        gcd=quot;// a?
        System.out.println("GCD is ");
        gcd.print();
        System.out.println("X is");
        x1.print();
        System.out.println("Y is");
        y1.print();


    }
}
