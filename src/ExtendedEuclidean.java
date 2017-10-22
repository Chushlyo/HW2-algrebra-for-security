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
    
    void compute(NewPolynomial a, NewPolynomial b) {

        while (!b.checkIfZero()) {
            System.out.println("Long Division is:");
            a.print();
            b.print();
            longDivision.divide(a, b);
            quot = longDivision.quot;
            a = b;
            b=longDivision.rem;
            System.out.println("b is ");
            b.print();
            xPr=polynomialsArithmetic.difference(x1,polynomialsArithmetic.product(quot,x2).primeVersion(prime)).primeVersion(prime);
            xPr.removeLeadingO();
//            if(xPr.getDegree()>0) {
//          xPr.print();
//          NewPolynomial current=xPr.changeDegree(xPr.getDegree()-1,xPr);
//            xPr=current;
//           }
            yPr=polynomialsArithmetic.difference(y1,polynomialsArithmetic.product(quot,y2).primeVersion(prime)).primeVersion(prime);
            x1=x2;
            y1=y2;
            x2=xPr;
            y2=yPr;
            b.removeLeadingO();
//            int degree=b.getDegree();
//            while(b.getThisCoef(degree)==0 && degree!=0){
//                NewPolynomial Bcurrent=b.changeDegree(b.getDegree()-1,b);
//                b=Bcurrent;
//                degree=degree-1;
//            }
//            if(b.getDegree()==0){
//                break;
//            }
        }
        if (b.getThisCoef(0)!=0){
            gcd=new NewPolynomial("1");
        }else{
            gcd=a;// quot?
        }

        System.out.println("GCD is ");
        gcd.print();
        if (gcd==new NewPolynomial("1")){
            System.out.println("second poly:X is");
            x1.printWL();
            System.out.println("first poly:Y is");
            y1.printWL();
        }else{
            System.out.println("second poly:X is");
            x1.printWL();
            System.out.println("first poly:Y is");
            y1.printWL();
        }



    }
}
