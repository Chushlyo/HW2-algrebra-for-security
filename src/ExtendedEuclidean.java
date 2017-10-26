/*
    Implements the euclidean algorithm as described in the reader
    However instead of xpr and ypr (u and v) being calculated at the end
    of the while loop they are calculated at the beginning with the old values.
    At the end y1 * b + x1 * a = gcd(a,b);
*/
public class ExtendedEuclidean {
 
    PolynomialsArithmetic polynomialsArithmetic = new PolynomialsArithmetic();
    LongDivision longDivision;
    NewPolynomial quot, xPr, yPr,gcd;
    NewPolynomial x1 = new NewPolynomial("1");
    NewPolynomial x2 = new NewPolynomial("0");
    NewPolynomial y2 = new NewPolynomial("1");
    NewPolynomial y1 = new NewPolynomial("0");
    int prime;
    
    public ExtendedEuclidean(int p){
        this.prime = p;
        longDivision = new LongDivision(prime);
    }
    
    NewPolynomial compute(NewPolynomial a, NewPolynomial b) {
        while (!b.checkIfZero()) {
            longDivision.divide(a, b);
            quot = longDivision.quot;
            a = b;
            b=longDivision.rem;
            xPr=polynomialsArithmetic.difference(x1,polynomialsArithmetic.product(quot,x2).primeVersion(prime)).primeVersion(prime);
            xPr.removeLeadingO();
            yPr=polynomialsArithmetic.difference(y1,polynomialsArithmetic.product(quot,y2).primeVersion(prime)).primeVersion(prime);
            x1=x2;
            y1=y2;
            x2=xPr;
            y2=yPr;
            b.removeLeadingO();
        }
        if (b.getThisCoef(0)!=0){
            gcd=new NewPolynomial("1");
        }else{
            gcd=a;
        }
        gcd.removeLeadingO();
     return gcd;
    }
}
