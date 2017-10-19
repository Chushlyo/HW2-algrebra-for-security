public class ExtendedEuclidean {
    PolynomialsArithmetic polynomialsArithmetic = new PolynomialsArithmetic();
    LongDivision longDivision = new LongDivision();
    NewPolynomial quot, xPr, yPr;
    NewPolynomial x = new NewPolynomial("1");
    NewPolynomial v = new NewPolynomial("1");
    NewPolynomial y = new NewPolynomial("0");
    NewPolynomial u = new NewPolynomial("0");

    void compute(NewPolynomial a, NewPolynomial b) {

        while (b.getDegree() != 0) {
            longDivision.divide(a, b);
            quot = longDivision.quot;
            a = b;
            b = longDivision.rem;
            xPr = x;
            yPr = y;
            x = u;
            y = v;
            u = polynomialsArithmetic.difference(xPr, polynomialsArithmetic.product(quot, u));
            NewPolynomial current = u.changeDegree(u.getDegree() - 1, u);
            u = current;
            v = polynomialsArithmetic.difference(yPr, polynomialsArithmetic.product(quot, v));
            NewPolynomial current2 = v.changeDegree(v.getDegree() - 1, v);
            v = current2;

        }

        System.out.println("X is");
        x.print();
        System.out.println("Y is");
        y.print();
    }
}
